plugins {
  alias(libs.plugins.androidLibrary)
  alias(libs.plugins.kotlinAndroid)
  alias(libs.plugins.parcelize)
  alias(libs.plugins.serialization)
}

android {
  namespace = "app.kaito_dogi.mybrary.core.ui"
  compileSdk = 34

  defaultConfig {
    minSdk = 24

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
    jvmTarget = "17"
  }

//  buildFeatures {
//    compose = true
//  }

//  composeOptions {
//    kotlinCompilerExtensionVersion = libs.versions.androidxComposeCompiler.get()
//  }
}

dependencies {
  implementation(project(":core:domain"))

  implementation(libs.serialization)
}
