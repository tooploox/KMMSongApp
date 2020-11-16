val kotlinVersion: String = "1.4.0"
val kodeinVersion: String = "7.1.0"
val jUnitVersion: String = "4.13.1"
val coroutinesVersion: String = "1.4.0"
val composeVersion: String = "1.0.0-alpha07"
val lifecycleVersion: String = "2.2.0"

extra.apply {
    set(
        "coroutinesCore",
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${coroutinesVersion}"
    )
    set(
        "coroutinesAndroid",
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${coroutinesVersion}"
    )
    set(
        "coroutinesCoreNative",
        "org.jetbrains.kotlinx:kotlinx-coroutines-core-common:1.3.8"
    )

    set(
        "composeUi",
        "androidx.compose.ui:ui:${composeVersion}"
    )
    set(
        "composeMaterial",
        "androidx.compose.material:material:${composeVersion}"
    )
    set(
        "composeLiveData",
        "androidx.compose.runtime:runtime-livedata:${composeVersion}"
    )
    set(
        "composeRuntime",
        "androidx.compose.runtime:runtime:${composeVersion}"
    )
    set(
        "composeFoundation",
        "androidx.compose.foundation:foundation:${composeVersion}"
    )
    set(
        "composeFoundationLayout",
        "androidx.compose.foundation:foundation-layout:${composeVersion}"
    )

    set(
        "uiTooling",
        "androidx.ui:ui-tooling:${composeVersion}"
    )

    set(
        "serialization",
        "org.jetbrains.kotlinx:kotlinx-serialization-json:1.0.0-RC2"
    )

    set(
        "androidXCore",
        "androidx.core:core-ktx:1.3.2"
    )
    set(
        "material",
        "com.google.android.material:material:1.2.1"
    )
    set(
        "appCompat",
        "androidx.appcompat:appcompat:1.2.0"
    )
    set(
        "constraintLayout",
        "androidx.constraintlayout:constraintlayout:2.0.3"
    )
    set(
        "lifecycleRuntime",
        "androidx.lifecycle:lifecycle-runtime-ktx:${lifecycleVersion}"
    )

    set(
        "lifecycleLiveData",
        "androidx.lifecycle:lifecycle-livedata-ktx:${lifecycleVersion}"
    )

    set(
        "kodeinAndroid",
        "org.kodein.di:kodein-di-framework-android-x:${kodeinVersion}"
    )
    set(
        "kodein",
        "org.kodein.di:kodein-di:${kodeinVersion}"
    )

    set(
        "gradle",
        "com.android.tools.build:gradle:4.0.0"
    )
    set(
        "kotilnGradlePlugin",
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${kotlinVersion}"
    )

    set(
        "jUnit",
        "junit:junit:${jUnitVersion}"
    )

    set(
        "testCommon",
        "test-common"
    )
    set(
        "testJUnit",
        "test-junit"
    )
    set(
        "testAnnotationsCommon",
        "test-annotations-common"
    )
}
