plugins {
  alias(libs.plugins.android.library)
  alias(libs.plugins.hilt.android)
  alias(libs.plugins.kotlin.android)
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

  implementation(libs.hilt.android)
  implementation(libs.okhttp)
  implementation(libs.okhttp.logging.interceptor)
  implementation(libs.retrofit)
  implementation(libs.retrofit.converter.kotlinx.serialization)
  implementation(libs.kotlinx.serialization)

  ksp(libs.hilt.android.compiler)
}
