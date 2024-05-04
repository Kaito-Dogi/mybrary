plugins {
  id("com.android.application")
  id("kotlin-android")
  id("kotlin-kapt")
  id("com.google.dagger.hilt.android")
  id("androidx.navigation.safeargs.kotlin")
}

android {
  namespace = "app.doggy.mybrary"
  compileSdk = 34

  defaultConfig {
    applicationId = "app.doggy.mybrary"
    minSdk = 24
    targetSdk = 34
    versionCode = 1
    versionName = "0.1"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
  implementation(project(":feature:book"))

  // TODO: feature モジュール実装後に削除
  implementation(project(":core:common"))
  implementation(project(":core:domain"))
  implementation(project(":core:data"))

  // Jetpack Compose
  val composeBom = platform(libs.androidx.compose.bom)
  implementation(composeBom)
  androidTestImplementation(composeBom)
  implementation(libs.androidx.compose.material3)
  implementation(libs.androidx.compose.ui.tooling.preview)
  debugImplementation(libs.androidx.compose.ui.tooling)
  implementation(libs.androidx.activity.compose)

  // TODO: feature モジュール実装後に削除
  implementation(libs.androidx.appcompat)
  implementation(libs.androidx.constraintlayout)
  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.fragment.ktx)
  implementation(libs.androidx.navigation.fragment)
  implementation(libs.androidx.navigation.ui)
  implementation(libs.coil)
  implementation(libs.groupie)
  implementation(libs.groupie.viewbinding)
  implementation(libs.hilt.android)
  implementation(libs.kotlinx.coroutines.android)
  implementation(libs.material)

  kapt(libs.hilt.compiler)
}

// TODO: core:data モジュール実装後に削除
kapt {
  correctErrorTypes = true
}
