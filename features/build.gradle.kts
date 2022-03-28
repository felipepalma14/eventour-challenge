plugins {
    id("commons.android-module")
}

dependencies {
    Depends.Features.Eventour.getAndroidModules().forEach { implementation(project(it)) }
}