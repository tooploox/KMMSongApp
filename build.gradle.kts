buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
    }
    //dependencies
    apply(from = "dependencies.gradle.kts")

    val kotilnGradlePlugin: String by extra
    val gradle: String by extra

    dependencies {
        classpath(kotilnGradlePlugin)
        classpath(gradle)
    }
}

group = "com.github.wzieba.songapp"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
