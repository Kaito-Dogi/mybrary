plugins {
  alias(libs.plugins.android.library)
  alias(libs.plugins.hilt.android)
  alias(libs.plugins.kotlin.android)
  alias(libs.plugins.ksp)
}

android {
  namespace = "app.kaito_dogi.mybrary.core.data"
  compileSdk = libs.versions.compileSdk.get().toInt()

  defaultConfig {
    minSdk = libs.versions.minSdk.get().toInt()

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  flavorDimensions += "env"
  productFlavors {
    create("prod") {
      dimension = "env"
    }

    create("dev") {
      dimension = "env"
    }

    create("mock") {
      dimension = "env"
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
  implementation(project(":core:common"))
  implementation(project(":core:config"))
  implementation(project(":core:database"))
  implementation(project(":core:domain"))

  implementation(libs.hilt.android)

  ksp(libs.hilt.android.compiler)

  testImplementation(libs.junit)
}
