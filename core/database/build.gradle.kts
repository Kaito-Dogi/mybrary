plugins {
  alias(libs.plugins.android.library)
  alias(libs.plugins.hilt.android)
  alias(libs.plugins.kotlin.android)
  alias(libs.plugins.ksp)
}

android {
  namespace = "app.kaito_dogi.mybrary.core.database"
  compileSdk = libs.versions.compileSdk.get().toInt()

  defaultConfig {
    minSdk = libs.versions.minSdk.get().toInt()

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    javaCompileOptions {
      annotationProcessorOptions {
        argument("room.schemaLocation", "$projectDir/schemas")
      }
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
  implementation(libs.hilt.android)
  implementation(libs.androidx.room)
  implementation(libs.androidx.room.runtime)

  ksp(libs.hilt.android.compiler)
  ksp(libs.androidx.room.compiler)
}
