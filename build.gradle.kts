// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
  repositories {
    google()
    mavenCentral()
  }

  dependencies {
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${libs.versions.kotlin}")
    // FIXME: libs.versions.androidxNavigation を使用するとエラーが発生する
    classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.6.0")
  }
}

plugins {
  alias(libs.plugins.android.application) apply false
  alias(libs.plugins.android.library) apply false
  alias(libs.plugins.hilt) apply false
  alias(libs.plugins.kotlin.android) apply false
}

tasks.create<Delete>("clean") {
  delete(rootProject.buildDir)
}
