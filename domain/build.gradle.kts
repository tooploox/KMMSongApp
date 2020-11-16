import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    id("com.android.library")
}
group = "com.github.wzieba.songapp"
version = "1.0-SNAPSHOT"

repositories {
    gradlePluginPortal()
    google()
    jcenter()
    mavenCentral()
}

//dependencies
apply(from = "../dependencies.gradle.kts")

val kodein: String by extra
val coroutinesCore: String by extra
val coroutinesCoreNative: String by extra
val testCommon: String by extra
val testAnnotationsCommon: String by extra
val coroutinesAndroid: String by extra
val material: String by extra
val androidXCore: String by extra
val testJUnit: String by extra
val jUnit: String by extra

kotlin {
    android {
        tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    ios {
        binaries {
            framework {
                baseName = "domain"
            }
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kodein)
                implementation(coroutinesCore)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin(testCommon))
                implementation(kotlin(testAnnotationsCommon))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(coroutinesAndroid)
                implementation(material)
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin(testJUnit))
                implementation(jUnit)
            }
        }
        val iosMain by getting {
            dependencies {
                implementation(coroutinesCoreNative)
            }
        }
        val iosTest by getting
    }
}
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().all {
    kotlinOptions.freeCompilerArgs += listOf(
        "-Xuse-experimental=kotlinx.coroutines.ExperimentalCoroutinesApi",
        "-Xuse-experimental=kotlinx.coroutines.FlowPreview"
    )
}
android {
    compileSdkVersion(29)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
}
val packForXcode by tasks.creating(Sync::class) {
    group = "build"
    val mode = System.getenv("CONFIGURATION") ?: "DEBUG"
    val sdkName = System.getenv("SDK_NAME") ?: "iphonesimulator"
    val targetName = "ios" + if (sdkName.startsWith("iphoneos")) "Arm64" else "X64"
    val framework = kotlin.targets.getByName<KotlinNativeTarget>(targetName).binaries.getFramework(mode)
    inputs.property("mode", mode)
    dependsOn(framework.linkTask)
    val targetDir = File(buildDir, "xcode-frameworks")
    from({ framework.outputDirectory })
    into(targetDir)
}
tasks.getByName("build").dependsOn(packForXcode)
