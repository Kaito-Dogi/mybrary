// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
  repositories {
    google()
    mavenCentral()
  }
  dependencies {
    classpath("com.android.tools.build:gradle:7.3.1")
    classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.5.3")
  }
}

plugins {
  id("org.jetbrains.kotlin.android") version "1.8.20" apply false
  id("com.google.dagger.hilt.android") version "2.45" apply false
}

allprojects {
  repositories {
    google()
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
  }
}

// task clean (type: Delete) {
//   delete = rootProject.buildDir
// }
