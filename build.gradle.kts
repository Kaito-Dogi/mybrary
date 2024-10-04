// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
  repositories {
    google()
    mavenCentral()
  }

  dependencies {
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${libs.versions.kotlin}")
  }
}

plugins {
  alias(libs.plugins.android.application) apply false
  alias(libs.plugins.android.library) apply false
  alias(libs.plugins.hilt.android) apply false
  alias(libs.plugins.jetbrains.kotlin.jvm) apply false
  alias(libs.plugins.kotlin.android) apply false
  alias(libs.plugins.ksp) apply false
  alias(libs.plugins.parcelize) apply false
  alias(libs.plugins.serialization) apply false
}
