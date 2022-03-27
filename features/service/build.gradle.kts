plugins {
    id("commons.android-module")
}

dependencies {
    Depends.Features.Eventour.setup().forEach{ implementation(project(it)) }
}