import org.gradle.api.Project

object Depends {
    object Kotlin {
        fun getKotlinStdlibVersion() = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinVersion}"
        fun getKotlinReflect() = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlinVersion}"

        fun setup(ext: Project) : Array<String> {
            return with(ext) {
                arrayOf(
                    getKotlinStdlibVersion(),
                    getKotlinReflect()
                )
            }
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
        fun getDaggerSupport() = "com.google.dagger:dagger-android-support:${Versions.daggerVersion}"
        fun getDaggerCompiler() = "com.google.dagger:dagger-compiler:${Versions.daggerVersion}"
        fun getDaggerProcessor() = "com.google.dagger:dagger-android-processor:${Versions.daggerVersion}"

        fun setup(): Array<String>{
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
}