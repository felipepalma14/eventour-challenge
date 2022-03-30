plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

repositories {
    google()
    mavenCentral()
    maven("https://plugins.gradle.org/m2/")
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}

object Plugin {
    private fun getGradleAndroidVersion(): String = "com.android.tools.build:gradle:4.1.0"
    private fun getKotlinGradleVersion(): String = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.30"
    private fun getDetektVersion(): String = "io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.17.0"
    fun setup() = arrayOf(
        getGradleAndroidVersion(),
        getKotlinGradleVersion(),
        getDetektVersion()
    )
}

dependencies {
    Plugin.setup().forEach { implementation(it) }
}