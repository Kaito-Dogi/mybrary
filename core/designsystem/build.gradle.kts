plugins {
  id("com.android.library")
  id("kotlin-android")
}

android {
  namespace = "app.doggy.mybrary.core.designsystem"
  compileSdk = 34

  defaultConfig {
    minSdk = 24

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
  val composeBom = platform(libs.androidx.compose.bom)
  implementation(composeBom)
  // androidTestImplementation(composeBom)
  implementation(libs.androidx.compose.material3)
  // implementation(libs.androidx.compose.ui.tooling.preview)
  // debugImplementation(libs.androidx.compose.ui.tooling)
  // implementation(libs.androidx.activity.compose)
  implementation(libs.androidx.core.ktx)
}
