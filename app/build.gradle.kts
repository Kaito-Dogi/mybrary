plugins {
  alias(libs.plugins.androidApplication)
  alias(libs.plugins.hilt)
  alias(libs.plugins.kotlinAndroid)
  id("kotlin-kapt")
}

android {
  namespace = "app.kaito_dogi.mybrary"
  compileSdk = libs.versions.compileSdk.get().toInt()

  defaultConfig {
    applicationId = "app.kaito_dogi.mybrary"
    minSdk = libs.versions.minSdk.get().toInt()
    targetSdk = libs.versions.targetSdk.get().toInt()
    versionCode = libs.versions.versionCode.get().toInt()
    versionName = libs.versions.versionName.get()

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
  implementation(project(":core:data"))
  implementation(project(":core:designsystem"))
  implementation(project(":core:domain"))
  implementation(project(":feature:mybooklist"))
  implementation(project(":feature:mybookdetail"))
  implementation(project(":feature:searchbook"))

  // Jetpack Compose
  val composeBom = platform(libs.androidxComposeBom)
  implementation(composeBom)
  implementation(libs.androidxNavigationCompose)

  implementation(libs.hiltAndroid)
  implementation(libs.material)

  kapt(libs.hiltCompiler)
}

// TODO: core:data モジュール実装後に削除
kapt {
  correctErrorTypes = true
}
