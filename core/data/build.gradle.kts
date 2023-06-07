plugins {
  id("com.android.library")
  id("kotlin-android")
  id("kotlin-kapt")
  id("com.google.dagger.hilt.android")
}

android {
  namespace = "app.doggy.mybrary.core.data"
  compileSdk = 33

  defaultConfig {
    minSdk = 24
    targetSdk = 33

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    javaCompileOptions {
      annotationProcessorOptions {
        argument("room.schemaLocation", "$projectDir/schemas")
      }
    }
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
}

dependencies {
  implementation(project(":core:model"))

  implementation(libs.hilt.android)
  implementation(libs.moshi)
  implementation(libs.okhttp)
  implementation(libs.okhttp.logging)
  implementation(libs.retrofit)
  implementation(libs.retrofit.converter.moshi)
  implementation(libs.room.runtime)

  kapt(libs.hilt.compiler)
  kapt(libs.room.compiler)

  testImplementation(libs.junit)
}

kapt {
  correctErrorTypes = true
}
