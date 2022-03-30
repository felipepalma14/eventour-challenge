plugins {
    id("commons.android-module")
    id("kotlin-android")
}

dependencies {
    Depends.Features.Commons.setup().forEach { implementation(project(it)) }
    implementation(project(Depends.Features.Eventour.service))
    implementation(Depends.UI.getShimmerVersion())
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("com.google.android.material:material:1.5.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")
}