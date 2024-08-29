plugins {
  alias(libs.plugins.androidLibrary)
  alias(libs.plugins.hiltAndroid)
  alias(libs.plugins.kotlinAndroid)
  alias(libs.plugins.ksp)
}

android {
  namespace = "app.kaito_dogi.mybrary.core.data"
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

  implementation(libs.hiltAndroid)

  ksp(libs.hiltCompiler)

  testImplementation(libs.junit)
}
