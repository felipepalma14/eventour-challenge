plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(BuildAndroidConfig.COMPILE_SDK_VERSION)
    defaultConfig {
        minSdkVersion(BuildAndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(BuildAndroidConfig.TARGET_SDK_VERSION)

        versionCode = BuildAndroidConfig.VERSION_CODE
        versionName = BuildAndroidConfig.VERSION_NAME

        vectorDrawables.useSupportLibrary = BuildAndroidConfig.SUPPORT_LIBRARY_VECTOR_DRAWABLES
        testInstrumentationRunner = BuildAndroidConfig.TEST_INSTRUMENTATION_RUNNER
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            isDebuggable = false
        }

        getByName("debug") {
//            applicationIdSuffix = BuildTypeDebug.applicationIdSuffix
//            versionNameSuffix = BuildTypeDebug.versionNameSuffix
            isMinifyEnabled = false
            isDebuggable = true
        }
    }

    buildFeatures{
        dataBinding = true
    }

    androidExtensions {
        isExperimental = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    sourceSets {
        getByName("main") {
            java.srcDir("src/main/java")
        }
        getByName("test") {
            java.srcDir("src/test/java")
        }
        getByName("androidTest") {
            java.srcDir("src/androidTest/java")
        }
    }
}

dependencies {
    // implementation(project(BuildModules.CORE))
    Depends.Kotlin.setup().forEach { implementation(it) }

    Depends.AndroidUI.setup().forEach { implementation(it) }


    Depends.Dagger.setup().forEach { implementation(it) }

    Depends.Dagger.setupProcessor().forEach { kapt(it) }


//    implementation(Dependencies.TIMBER)
//    implementation(Dependencies.LOGGING)
//    implementation(Dependencies.DAGGER)

    //debugImplementation(DebugDependencies.LEAKCANARY)

    // kapt(AnnotationProcessorsDependencies.DAGGER)

    // addTestsDependencies()
}