plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.kotlin.android)
  id("kotlin-kapt")
  alias(libs.plugins.hilt)
}

android {
  namespace = "app.kaito_dogi.mybrary"
  compileSdk = 34

  defaultConfig {
    applicationId = "app.kaito_dogi.mybrary"
    minSdk = 24
    targetSdk = 34
    versionCode = 1
    versionName = "0.1"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(
        getDefaultProguardFile("proguard-android-optimize.txt"),
        "proguard-rules.pro",
      )
    }

    create("mock") {
      initWith(getByName("debug"))
      matchingFallbacks += listOf("debug")
    }
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }

  kotlinOptions {
    jvmTarget = "17"
  }

  buildFeatures {
    compose = true
  }

  composeOptions {
    kotlinCompilerExtensionVersion = libs.versions.androidxComposeCompiler.get()
  }
}

dependencies {
  implementation(project(":core:designsystem"))
  implementation(project(":core:domain"))
  implementation(project(":feature:mybooklist"))
  implementation(project(":feature:mybookdetail"))
  implementation(project(":feature:searchbook"))

  // Jetpack Compose
  val composeBom = platform(libs.androidx.compose.bom)
  implementation(composeBom)
  implementation(libs.androidx.navigation.compose)

  implementation(libs.hilt.android)
  implementation(libs.material)

  kapt(libs.hilt.compiler)
}

// TODO: core:data モジュール実装後に削除
kapt {
  correctErrorTypes = true
}
