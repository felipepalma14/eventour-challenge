object Depends {
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

    object AndroidUI {
        fun getConstraintLayoutVersion() = "androidx.constraintlayout:constraintlayout:2.1.3"
        fun getAppCompat() = "androidx.appcompat:appcompat:1.1.0"
        fun getMaterialDesign() = "com.google.android.material:material:1.4.0"
        fun getCoreKTX() = "androidx.core:core-ktx:1.1.0"

        fun setup(): Array<String> {
            return arrayOf(
                getAppCompat(),
                getConstraintLayoutVersion(),
                getMaterialDesign(),
                getCoreKTX()
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
            "androidx.lifecycle:lifecycle-livedata-kts:${Versions.lifecycleVersion}"

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