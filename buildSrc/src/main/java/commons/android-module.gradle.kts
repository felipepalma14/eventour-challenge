package commons

import org.gradle.kotlin.dsl.kotlin

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-android-extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(BuildAndroidConfig.COMPILE_SDK_VERSION)
    defaultConfig {
        minSdkVersion(BuildAndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(BuildAndroidConfig.TARGET_SDK_VERSION)
    }


    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            consumerProguardFiles("proguard-rules.pro")
        }

        getByName("debug") {
            isMinifyEnabled = false
            isDebuggable = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures{
        dataBinding = true
    }

    kotlinOptions {
        jvmTarget = org.gradle.api.JavaVersion.VERSION_1_8.toString()
    }

    androidExtensions {
        isExperimental = true
    }

    packagingOptions{
        exclude("META-INF/*.kotlin-module")
    }

    sourceSets {
        getByName("main") {
            java.srcDir("src/main/java")
        }
        getByName("test") {
            java.srcDir("src/test/java")
        }
    }
}

dependencies {

    Depends.Kotlin.setup().forEach { implementation(it) }

    Depends.AndroidUI.setup().forEach { implementation(it) }

    Depends.Dagger.setup().forEach { implementation(it) }

    Depends.Dagger.setupProcessor().forEach { kapt(it) }

    Depends.ViewModel.setup().forEach { implementation(it) }

    Depends.Retrofit.setup().forEach { implementation(it) }
    
    Depends.OkHttp3.setup().forEach { implementation(it) }

    Depends.UnitTest.setup().forEach { testImplementation(it) }

}