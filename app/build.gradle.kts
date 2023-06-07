plugins {
  id("com.android.application")
  id("kotlin-android")
  id("kotlin-kapt")
  id("com.google.dagger.hilt.android")
  id("androidx.navigation.safeargs.kotlin")
}

android {
  namespace = "app.doggy.newmybrary"
  compileSdk = 33

  defaultConfig {
    applicationId = "app.doggy.newmybrary"
    minSdk = 24
    targetSdk = 33
    versionCode = 2
    versionName = "2.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    // core:data モジュール実装後に削除
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
  buildFeatures {
    viewBinding = true
  }
}

dependencies {
  implementation(project(":core:data"))

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

  // core:data モジュール実装後に削除
  // ===== ここから =====
  implementation(libs.moshi)
  implementation(libs.okhttp)
  implementation(libs.okhttp.logging)
  implementation(libs.retrofit)
  implementation(libs.retrofit.converter.moshi)
  implementation(libs.room.runtime)
  kapt(libs.hilt.compiler)
  kapt(libs.room.compiler)
  // ===== ここまで =====

  testImplementation(libs.junit)

  androidTestImplementation(libs.androidx.test.ext.junit.ktx)
  androidTestImplementation(libs.androidx.test.espresso.core)
}

// core:data モジュール実装後に削除
kapt {
  correctErrorTypes = true
}
