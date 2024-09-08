plugins {
  alias(libs.plugins.androidLibrary)
  alias(libs.plugins.hiltAndroid)
  alias(libs.plugins.kotlinAndroid)
  alias(libs.plugins.ksp)
  alias(libs.plugins.serialization)
}

android {
  namespace = "app.kaito_dogi.mybrary.core.api"
  compileSdk = libs.versions.compileSdk.get().toInt()

  defaultConfig {
    minSdk = libs.versions.minSdk.get().toInt()

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }

  kotlinOptions {
    jvmTarget = libs.versions.jvmTarget.get()
  }

  buildFeatures {
    buildConfig = true
  }
}

dependencies {
  implementation(project(":core:common"))

  implementation(libs.hiltAndroid)
  implementation(libs.okhttp)
  implementation(libs.okhttpLogging)
  implementation(libs.retrofit)
  implementation(libs.retrofitConverterSerialization)
  implementation(libs.serialization)

  ksp(libs.hiltCompiler)
}
