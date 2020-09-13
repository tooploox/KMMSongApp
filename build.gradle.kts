buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
    }
    dependencies {
//        1.4.10 blocked by Kodein
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.72")
        classpath("com.android.tools.build:gradle:4.0.0")
    }
}
group = "com.github.wzieba.songapp"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
