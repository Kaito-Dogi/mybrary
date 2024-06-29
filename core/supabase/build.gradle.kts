plugins {
  alias(libs.plugins.androidLibrary)
  alias(libs.plugins.hilt)
  alias(libs.plugins.kotlinAndroid)
  alias(libs.plugins.serialization)
  id("kotlin-kapt")
}

android {
  namespace = "app.kaito_dogi.mybrary.core.supabase"
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
}

dependencies {
  implementation(project(":core:api"))
  implementation(project(":core:config"))

  implementation(libs.hiltAndroid)
  implementation(libs.ktor)
  implementation(platform(libs.supabaseBom))
  implementation(libs.supabasePostgrestKt)

  kapt(libs.hiltCompiler)
}
