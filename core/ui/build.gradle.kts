plugins {
  alias(libs.plugins.androidLibrary)
  alias(libs.plugins.kotlinAndroid)
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
    kotlinCompilerExtensionVersion = libs.versions.androidxComposeCompiler.get()
  }
}

dependencies {
  implementation(project(":core:common"))
  implementation(project(":core:design-system"))
  implementation(project(":core:domain"))

  implementation(platform(libs.androidxComposeBom))
  implementation(libs.androidxComposeMaterial3)
  implementation(libs.androidxComposeUiTooling)
  implementation(libs.androidxComposeUiToolingPreview)
  implementation(libs.androidxHiltNavigationCompose)
  implementation(libs.androidxLifecycleRuntimeCompose)
  implementation(libs.androidxNavigationCompose)
  implementation(libs.coilCompose)
  implementation(libs.serialization)
}
