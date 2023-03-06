plugins {
    id("java-gradle-plugin")
    kotlin("jvm") version "1.8.0"
//    id("groovy")
}
repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation("com.android.tools.build:gradle:7.4.2")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.8.0")
//    implementation("org.jetbrains.kotlin:kotlin-compiler:1.8.0")
}

gradlePlugin {
    plugins {
        register("normalPlugin") {
            id = "com.yly.normalPlugin"
            implementationClass = "com.example.normal.gitmanifest.ExamplePlugin"
        }
        register("extensionPlugin") {
            id = "com.yly.extensionPlugin"
            implementationClass = "com.example.normal.extension.ExamplePlugin"
        }
        register("lifecyclePlugin") {
            id = "com.yly.lifecyclePlugin"
            implementationClass = "com.example.normal.lifecycle.ExamplePlugin"
        }
    }
}