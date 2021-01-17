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
dependencies {
    implementation(project(":domain"))
    implementation(project(":local"))
    implementation("com.google.android.material:material:1.2.1")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.2.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.2.0")
    implementation("org.kodein.di:kodein-di-framework-android-x:7.0.0")
    implementation("androidx.compose.ui:ui:1.0.0-alpha07")
    implementation("androidx.compose.material:material:1.0.0-alpha07")
    implementation("androidx.ui:ui-tooling:1.0.0-alpha07")
    implementation("androidx.compose.runtime:runtime-livedata:1.0.0-alpha07")
    implementation("androidx.compose.foundation:foundation:1.0.0-alpha07")
    implementation("androidx.compose.foundation:foundation-layout:1.0.0-alpha07")
    implementation("androidx.compose.runtime:runtime:1.0.0-alpha07")
}
android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "com.github.wzieba.songapp.androidApp"
        minSdkVersion(24)
        targetSdkVersion(30)
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
        kotlinCompilerExtensionVersion = "1.0.0-alpha07"
        kotlinCompilerVersion = "1.4.10"
    }
}
