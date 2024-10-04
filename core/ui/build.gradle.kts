plugins {
  alias(libs.plugins.android.library)
  alias(libs.plugins.hilt.android)
  alias(libs.plugins.kotlin.android)
  alias(libs.plugins.ksp)
  alias(libs.plugins.parcelize)
  alias(libs.plugins.serialization)
}

android {
  namespace = "app.kaito_dogi.mybrary.core.ui"
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
    compose = true
  }

  composeOptions {
    kotlinCompilerExtensionVersion = libs.versions.androidx.compose.compiler.get()
  }
}

dependencies {
  implementation(project(":core:common"))
  implementation(project(":core:design-system"))
  implementation(project(":core:domain"))

  implementation(libs.androidx.browser)
  implementation(platform(libs.androidx.compose.bom))
  implementation(libs.androidx.compose.material3)
  implementation(libs.androidx.compose.ui.tooling)
  implementation(libs.androidx.compose.ui.tooling.preview)
  implementation(libs.androidx.hilt.navigation.compose)
  implementation(libs.androidx.lifecycle.runtime.compose)
  implementation(libs.androidx.navigation.compose)
  implementation(libs.coil.compose)
  implementation(libs.hilt.android)
  implementation(libs.kotlinx.serialization)

  ksp(libs.hilt.android.compiler)
}
