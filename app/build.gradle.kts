plugins {
  id("com.android.application")
  id("kotlin-android")
  id("kotlin-kapt")
  id("com.google.dagger.hilt.android")
  id("androidx.navigation.safeargs.kotlin")
}

android {
  compileSdk = 33

  defaultConfig {
    applicationId = "app.doggy.newmybrary"
    minSdk = 24
    targetSdk = 33
    versionCode = 2
    versionName = "2.0"

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
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  kotlinOptions {
    jvmTarget = "1.8"
  }
  buildFeatures {
    viewBinding = true
  }
}

dependencies {
  implementation("androidx.core:core-ktx:1.10.0")
  implementation("androidx.appcompat:appcompat:1.6.1")
  implementation("com.google.android.material:material:1.8.0")
  implementation("androidx.constraintlayout:constraintlayout:2.1.4")
  testImplementation("junit:junit:4.13.2")
  androidTestImplementation("androidx.test.ext:junit:1.1.5")
  androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

  // Retrofit
  implementation("com.squareup.retrofit2:retrofit:2.9.0")
  implementation("com.squareup.retrofit2:converter-moshi:2.9.0")

  // Okhttp
  implementation("com.squareup.okhttp3:okhttp:4.10.0")
  implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")

  // Moshi
  implementation("com.squareup.moshi:moshi:1.14.0")
  implementation("com.squareup.moshi:moshi-kotlin:1.14.0")

  // coroutines
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

  // Coil
  implementation("io.coil-kt:coil:2.2.2")

  // hilt
  implementation("com.google.dagger:hilt-android:2.45")
  kapt("com.google.dagger:hilt-compiler:2.45")

  // Fragment
  implementation("androidx.fragment:fragment-ktx:1.5.7")

  // Navigation
  implementation("androidx.navigation:navigation-fragment-ktx:2.5.3")
  implementation("androidx.navigation:navigation-ui-ktx:2.5.3")

  // Room
  implementation("androidx.room:room-runtime:2.5.1")
  kapt("androidx.room:room-compiler:2.5.1")

  // Groupie
  implementation("com.github.lisawray.groupie:groupie:2.10.1")
  implementation("com.github.lisawray.groupie:groupie-viewbinding:2.10.1")
}

kapt {
  correctErrorTypes = true
}
