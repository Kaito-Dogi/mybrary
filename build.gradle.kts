// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
  repositories {
    google()
    mavenCentral()
  }

  dependencies {
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.20")
    classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.5.3")
  }
}

plugins {
  id("com.android.application") version "8.0.0" apply false
  id("com.android.library") version "8.0.0" apply false
  id("org.jetbrains.kotlin.android") version "1.8.20" apply false
  id("com.google.dagger.hilt.android") version "2.45" apply false
}

tasks.create<Delete>("clean") {
  delete(rootProject.buildDir)
}
