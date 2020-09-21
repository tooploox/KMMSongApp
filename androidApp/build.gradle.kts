plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android-extensions")
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
    implementation("com.google.android.material:material:1.2.0")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.8")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.2.0")
    implementation("org.kodein.di:kodein-di-framework-android-x:7.0.0")
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
    kotlinOptions{
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}