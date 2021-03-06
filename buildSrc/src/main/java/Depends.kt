object Depends {
    object Features {
        object Commons {
            const val testingBase = ":testingBase"
            const val commons = ":commons"

            fun getJavaModule() = arrayOf(testingBase)
            fun getAndroidModules() = arrayOf(commons)
            fun setup() = getJavaModule() + getAndroidModules()
        }

        object Eventour {
            val core = ":features"
            val service = ":features:service"
            val events = ":features:events"

            fun getAndroidModules() = arrayOf(events, service)
            fun getCoreModule() = arrayOf(core)

            fun setup() = getCoreModule() + getAndroidModules()
        }

        fun setup() = getAndroidModules() + getJavaModules() + getCoreModules()

        fun getCoreModules() = Eventour.getCoreModule()

        fun getAndroidModules() = Eventour.getAndroidModules()

        fun getJavaModules() = Commons.getJavaModule()
    }
    object Kotlin {
        fun getKotlinStdlibVersion() =
            "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinVersion}"

        fun getKotlinReflect() = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlinVersion}"

        fun setup(): Array<String> {
            return arrayOf(
                getKotlinStdlibVersion(),
                getKotlinReflect()
            )
        }

    }

    object UI {
        fun getShimmerVersion() = "com.facebook.shimmer:shimmer:0.5.0"
        fun getGlide() = "com.github.bumptech.glide:glide:4.11.0"
    }

    object AndroidUI {
        fun getConstraintLayoutVersion() = "androidx.constraintlayout:constraintlayout:2.1.3"
        fun getAppCompat() = "androidx.appcompat:appcompat:1.1.0"
        fun getMaterialDesign() = "com.google.android.material:material:1.4.0"
        fun getCoreKTX() = "androidx.core:core-ktx:1.1.0"
        fun getSupportV4() = "androidx.legacy:legacy-support-v4:1.0.0"

        fun setup(): Array<String> {
            return arrayOf(
                getAppCompat(),
                getConstraintLayoutVersion(),
                getMaterialDesign(),
                getCoreKTX(),
                getSupportV4()
            )
        }
    }

    object AndroidTest {
        fun getRunnerVersion() = "androidx.test:runner:${Versions.testRunnerVersion}"
        fun getRulesVersion() = "androidx.test:rules:${Versions.testRulesVersion}"

        fun setup(): Array<String> {
            return arrayOf(
                getRunnerVersion(),
                getRulesVersion()
            )
        }
    }

    object UnitTest {
        fun getCoreVersion() = "androidx.test:core:${Versions.unitTestCoreVersion}"
        fun getJUnitVersion() = "junit:junit:${Versions.jUnitVersion}"
        fun getViewModelTestVersion() = "androidx.arch.core:core-testing:${Versions.coreCommonsVersion}"
        fun getRunnerVersion() = "androidx.test:runner:${Versions.testRunnerVersion}"
        fun getTruthVersion() = "com.google.truth:truth:1.1.3"
        fun getMockitoInlineVersion() = "org.mockito:mockito-inline:${Versions.mockitoVersion}"
        fun getMockitoCoreVersion() = "org.mockito:mockito-core:${Versions.mockitoVersion}"
        fun getCoreKTX() = "androidx.core:core-ktx:1.1.0"
        fun getMockitoKotlinVersion() = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlinVersion}"
        fun getMockitoAndroidVersion() = "org.mockito:mockito-android:${Versions.mockitoAndroidVersion}"
        fun getCoroutineTest() = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.5.2"
        fun getCoroutineDebugTest() = "org.jetbrains.kotlinx:kotlinx-coroutines-debug:1.5.2"
        fun getMockkVersion() = "io.mockk:mockk:1.9.1"

        fun setupJavaModules() : Array<String> {
            return arrayOf(
                getJUnitVersion(),
                getMockitoInlineVersion(),
                getMockitoCoreVersion(),
                getMockitoKotlinVersion(),
                getCoreKTX(),
                getCoroutineTest(),
                getCoroutineDebugTest(),
                getTruthVersion(),
                getMockkVersion()
            )
        }

        fun setup(): Array<String> {
            return arrayOf(
                getCoroutineTest(),
                getCoreVersion(),
                getJUnitVersion(),
                getRunnerVersion(),
                getViewModelTestVersion(),
                getMockitoInlineVersion(),
                getMockitoCoreVersion(),
                getMockitoKotlinVersion(),
                getMockitoAndroidVersion(),
                getTruthVersion(),
                getMockkVersion()
            )
        }
    }

    object Dagger {
        fun getDaggerCore() = "com.google.dagger:dagger:${Versions.daggerVersion}"
        fun getDaggerAndroid() = "com.google.dagger:dagger-android:${Versions.daggerVersion}"
        fun getDaggerSupport() =
            "com.google.dagger:dagger-android-support:${Versions.daggerVersion}"

        fun getDaggerCompiler() = "com.google.dagger:dagger-compiler:${Versions.daggerVersion}"
        fun getDaggerProcessor() =
            "com.google.dagger:dagger-android-processor:${Versions.daggerVersion}"

        fun setup(): Array<String> {
            return arrayOf(
                getDaggerCore(),
                getDaggerAndroid(),
                getDaggerSupport()
            )
        }

        fun setupProcessor(): Array<String> {
            return arrayOf(getDaggerCompiler(), getDaggerProcessor())
        }
    }

    object ViewModel {
        fun getLifecycleExtensionsVersion() =
            "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleVersion}"

        fun getLifecycleLiveDataKtxVersion() =
            "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleVersion}"

        fun getLifecycleViewModelKtxVersion() =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}"

        fun setup(): Array<String> {
            return arrayOf(
                getLifecycleExtensionsVersion(),
                getLifecycleLiveDataKtxVersion(),
                getLifecycleViewModelKtxVersion()
            )
        }
    }

    object Retrofit {
        fun getCoreVersion() =
            "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"

        fun getRetrofitMoshiVersion() =
            "com.squareup.moshi:moshi-kotlin:${Versions.moshiVersion}"

        fun getRetrofitMoshiConverterVersion() =
            "com.squareup.retrofit2:converter-moshi:${Versions.retrofitVersion}"

        fun setup(): Array<String> {
            return arrayOf(
                getCoreVersion(),
                getRetrofitMoshiConverterVersion(),
                getRetrofitMoshiVersion()
            )
        }
    }

    object OkHttp3 {
        fun getCoreVersion() =
            "com.squareup.okhttp3:okhttp:${Versions.okHttp3Version}"

        fun getInterceptorVersion() =
            "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp3Version}"

        fun setup(): Array<String> {
            return arrayOf(
                getCoreVersion(),
                getInterceptorVersion()
            )
        }
    }
}