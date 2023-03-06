plugins {
    kotlin("jvm") version "1.8.0"
    id("java-gradle-plugin")
}

repositories {
    google()
    mavenCentral()
}
dependencies {
    implementation("com.android.tools.build:gradle:7.4.2")
    implementation(kotlin("stdlib"))
//    gradleApi()
}