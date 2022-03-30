package commons

plugins {
    kotlin
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    Depends.Kotlin.setup().forEach { implementation(it) }
    Depends.UnitTest.setupJavaModules().forEach { implementation(it) }
}
