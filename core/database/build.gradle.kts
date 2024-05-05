plugins {
  alias(libs.plugins.androidLibrary)
  alias(libs.plugins.hilt)
  alias(libs.plugins.kotlinAndroid)
  id("kotlin-kapt")
}

android {
  namespace = "app.kaito_dogi.mybrary.core.database"
  compileSdk = 34

  defaultConfig {
    minSdk = 24

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    consumerProguardFiles("consumer-rules.pro")

    javaCompileOptions {
      annotationProcessorOptions {
        argument("room.schemaLocation", "$projectDir/schemas")
      }
    }
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
}

dependencies {
  implementation(project(":core:common"))
  implementation(project(":core:domain"))

  implementation(libs.hiltAndroid)
  implementation(libs.roomKtx)
  implementation(libs.roomRuntime)

  kapt(libs.hiltCompiler)
  kapt(libs.roomCompiler)
}

kapt {
  correctErrorTypes = true
}
