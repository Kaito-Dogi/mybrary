plugins {
  alias(libs.plugins.androidLibrary)
  alias(libs.plugins.hiltAndroid)
  alias(libs.plugins.kotlinAndroid)
  alias(libs.plugins.ksp)
}

android {
  namespace = "app.kaito_dogi.mybrary.feature.mybooklist"
  compileSdk = libs.versions.compileSdk.get().toInt()

  defaultConfig {
    minSdk = libs.versions.minSdk.get().toInt()

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    consumerProguardFiles("consumer-rules.pro")
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(
        getDefaultProguardFile("proguard-android-optimize.txt"),
        "proguard-rules.pro",
      )
    }
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
  implementation(project(":core:ui"))

  implementation(platform(libs.androidxComposeBom))
  implementation(libs.androidxComposeMaterial3)
  implementation(libs.androidxComposeUiTooling)
  implementation(libs.androidxComposeUiToolingPreview)
  implementation(libs.androidxHiltNavigationCompose)
  implementation(libs.androidxLifecycleRuntimeCompose)
  implementation(libs.androidxNavigationCompose)
  implementation(libs.coilCompose)
  implementation(libs.hiltAndroid)
  implementation(libs.serialization)

  ksp(libs.hiltCompiler)
}
