import java.util.Properties

plugins {
  alias(libs.plugins.androidApplication)
  alias(libs.plugins.hiltAndroid)
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

    debug {
      applicationIdSuffix = ".debug"
      isDebuggable = true
    }

    create("mock") {
      initWith(getByName("debug"))
      applicationIdSuffix = ".mock"
      matchingFallbacks += listOf("debug")
    }
  }

  val properties = Properties()
  val secretsProperties = rootProject.file("./secrets.properties")
  if (secretsProperties.exists()) {
    properties.load(secretsProperties.inputStream())
  }

  flavorDimensions += "env"
  productFlavors {
    create("prod") {
      dimension = "env"

      buildConfigField(
        type = "String",
        name = "SUPABASE_URL",
        value = properties.getProperty("supabase.url.prod") ?: System.getenv("SUPABASE_URL_PROD"),
      )
      buildConfigField(
        type = "String",
        name = "SUPABASE_KEY",
        value = properties.getProperty("supabase.key.prod") ?: System.getenv("SUPABASE_KEY_PROD"),
      )
    }

    create("dev") {
      applicationIdSuffix = ".dev"
      dimension = "env"
      isDefault = true

      buildConfigField(
        type = "String",
        name = "SUPABASE_URL",
        value = properties.getProperty("supabase.url.dev") ?: System.getenv("SUPABASE_URL_DEV"),
      )
      buildConfigField(
        type = "String",
        name = "SUPABASE_KEY",
        value = properties.getProperty("supabase.key.dev") ?: System.getenv("SUPABASE_KEY_DEV"),
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

  buildFeatures {
    buildConfig = true
    compose = true
  }

  composeOptions {
    kotlinCompilerExtensionVersion = libs.versions.androidxComposeCompiler.get()
  }
}

dependencies {
  implementation(project(":core:config"))
  implementation(project(":core:data"))
  implementation(project(":core:design-system"))
  implementation(project(":core:domain"))
  implementation(project(":core:supabase"))
  implementation(project(":feature:login"))
  implementation(project(":feature:my-book-list"))
  implementation(project(":feature:my-book-detail"))
  implementation(project(":feature:search-books"))

  implementation(platform(libs.androidxComposeBom))
  implementation(libs.androidxNavigationCompose)
  implementation(libs.hiltAndroid)
  implementation(libs.material)

  kapt(libs.hiltCompiler)
}

// TODO: core:data モジュール実装後に削除
kapt {
  correctErrorTypes = true
}
