import plugins.Plugins

buildscript {

    repositories {
        mavenLocal()
        google()
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
    }

    dependencies {
        classpath("com.android.tools.build:gradle:${Versions.gradleVersion}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.20")
    }
}

allprojects {
    repositories {
        mavenLocal()
        google()
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
    }
    plugins.apply(Plugins.detekt)
}