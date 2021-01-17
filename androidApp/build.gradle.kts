plugins {
    id("com.android.application")
    kotlin("android")
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

val kotlinVersion: String by extra
val composeVersion: String by extra

val material: String by extra
val appCompat: String by extra
val constraintLayout: String by extra
val coroutinesAndroid: String by extra
val lifecycleRuntime: String by extra
val lifecycleLiveData: String by extra
val kodeinAndroid: String by extra

val composeUi: String by extra
val composeMaterial: String by extra
val composeLiveData: String by extra
val composeFoundation: String by extra
val composeFoundationLayout: String by extra
val composeRuntime: String by extra
val composeCompiler: String by extra

val uiTooling: String by extra

dependencies {
    implementation(project(":domain"))
    implementation(project(":local"))
    implementation(material)
    implementation(appCompat)
    implementation(constraintLayout)
    implementation(coroutinesAndroid)
    implementation(lifecycleRuntime)
    implementation(lifecycleLiveData)
    implementation(kodeinAndroid)
    implementation(composeCompiler)
    implementation(composeUi)
    implementation(composeMaterial)
    implementation(uiTooling)
    implementation(composeLiveData)
    implementation(composeFoundation)
    implementation(composeFoundationLayout)
    implementation(composeRuntime)
}
android {
    compileSdkVersion(29)
    defaultConfig {
        applicationId = "com.github.wzieba.songapp.androidApp"
        minSdkVersion(24)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
        useIR = true
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = composeVersion
        kotlinCompilerVersion = kotlinVersion
    }
}
