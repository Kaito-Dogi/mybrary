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
  alias(libs.plugins.androidApplication) apply false
  alias(libs.plugins.androidLibrary) apply false
  alias(libs.plugins.hilt) apply false
  alias(libs.plugins.jetbrainsKotlinJvm) apply false
  alias(libs.plugins.kotlinAndroid) apply false
  alias(libs.plugins.parcelize) apply false
  alias(libs.plugins.serialization) apply false
}
