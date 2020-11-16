import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("kotlin-android-extensions")
    kotlin("plugin.serialization") version "1.4.10"
}

repositories {
    gradlePluginPortal()
    google()
    jcenter()
    mavenCentral()
    maven {
        url = uri("https://dl.bintray.com/kotlin/kotlin-eap")
    }
}

//dependencies
apply(from = "../dependencies.gradle.kts")

val kodein: String by extra
val coroutinesCore: String by extra
val serialization: String by extra
val testCommon: String by extra
val testAnnotationsCommon: String by extra
val coroutinesAndroid: String by extra
val androidXCore: String by extra
val testJUnit: String by extra
val jUnit: String by extra

kotlin {
    android()
    ios {
        binaries {
            framework {
                baseName = "local"
            }
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kodein)
                implementation(coroutinesCore)
                implementation(serialization)
                implementation(project(":domain"))

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
                implementation(androidXCore)
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin(testJUnit))
                implementation(jUnit)
            }
        }
        val iosMain by getting
        val iosTest by getting
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}
android {
    compileSdkVersion(29)
    defaultConfig {
        minSdkVersion(24)
        targetSdkVersion(29)
    }
    sourceSets {
        getByName("main") {
            manifest.srcFile("src/androidMain/AndroidManifest.xml")
            // Here we make usable main/assets directory in Android-specific module
            // Should we do something similar for iOS, or maybe copy file during build phase?
            assets.srcDirs("src/main/assets")
        }
    }
}
val packForXcode by tasks.creating(Sync::class) {
    group = "build"
    val mode = System.getenv("CONFIGURATION") ?: "DEBUG"
    val sdkName = System.getenv("SDK_NAME") ?: "iphonesimulator"
    val targetName = "ios" + if (sdkName.startsWith("iphoneos")) "Arm64" else "X64"
    val framework =
        kotlin.targets.getByName<KotlinNativeTarget>(targetName).binaries.getFramework(mode)
    inputs.property("mode", mode)
    dependsOn(framework.linkTask)
    val targetDir = File(buildDir, "xcode-frameworks")
    from({ framework.outputDirectory })
    into(targetDir)
}
tasks.getByName("build").dependsOn(packForXcode)
