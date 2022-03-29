plugins {
    id("commons.android-module")
    id("kotlin-android")
}

dependencies {
    Depends.Features.Commons.setup().forEach { implementation(project(it)) }
    implementation(project(Depends.Features.Eventour.service))
    implementation(Depends.UI.getShimmerVersion())
}