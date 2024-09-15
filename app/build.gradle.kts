import java.util.Properties

val properties = Properties()
val secretsProperties = rootProject.file("./secrets.properties")
if (secretsProperties.exists()) {
  properties.load(secretsProperties.inputStream())
}

plugins {
  alias(libs.plugins.androidApplication)
  alias(libs.plugins.hiltAndroid)
  alias(libs.plugins.kotlinAndroid)
  alias(libs.plugins.ksp)
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

    buildConfigField(
      type = "String",
      name = "RAKUTEN_AFFILIATE_ID",
      value = properties.getProperty("rakuten.affiliateId.dev")
        ?: System.getenv("RAKUTEN_AFFILIATE_ID_DEV"),
    )
    buildConfigField(
      type = "String",
      name = "RAKUTEN_APPLICATION_ID",
      value = properties.getProperty("rakuten.applicationId.dev")
        ?: System.getenv("RAKUTEN_APPLICATION_ID_DEV"),
    )
    buildConfigField(
      type = "String",
      name = "SUPABASE_KEY",
      value = properties.getProperty("supabase.key.dev") ?: System.getenv("SUPABASE_KEY_DEV"),
    )
    buildConfigField(
      type = "String",
      name = "SUPABASE_URL",
      value = properties.getProperty("supabase.url.dev") ?: System.getenv("SUPABASE_URL_DEV"),
    )
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
  }

  flavorDimensions += "env"
  productFlavors {
    create("prod") {
      dimension = "env"

      buildConfigField(
        type = "String",
        name = "RAKUTEN_AFFILIATE_ID",
        value = properties.getProperty("rakuten.affiliateId.prod")
          ?: System.getenv("RAKUTEN_AFFILIATE_ID_PROD"),
      )
      buildConfigField(
        type = "String",
        name = "RAKUTEN_APPLICATION_ID",
        value = properties.getProperty("rakuten.applicationId.prod")
          ?: System.getenv("RAKUTEN_APPLICATION_ID_PROD"),
      )
      buildConfigField(
        type = "String",
        name = "SUPABASE_KEY",
        value = properties.getProperty("supabase.key.prod") ?: System.getenv("SUPABASE_KEY_PROD"),
      )
      buildConfigField(
        type = "String",
        name = "SUPABASE_URL",
        value = properties.getProperty("supabase.url.prod") ?: System.getenv("SUPABASE_URL_PROD"),
      )
    }

    create("dev") {
      applicationIdSuffix = ".dev"
      dimension = "env"
      isDefault = true
    }

    create("mock") {
      applicationIdSuffix = ".mock"
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

  buildFeatures {
    buildConfig = true
    compose = true
  }

  composeOptions {
    kotlinCompilerExtensionVersion = libs.versions.androidxComposeCompiler.get()
  }
}

dependencies {
  implementation(project(":core:api"))
  implementation(project(":core:common"))
  implementation(project(":core:config"))
  implementation(project(":core:data"))
  implementation(project(":core:database"))
  implementation(project(":core:design-system"))
  implementation(project(":core:domain"))
  implementation(project(":core:supabase"))
  implementation(project(":core:ui"))
  implementation(project(":feature:my-book"))
  implementation(project(":feature:my-book-detail"))
  implementation(project(":feature:my-book-list"))
  implementation(project(":feature:search-book"))
  implementation(project(":feature:send-otp"))
  implementation(project(":feature:verify-otp"))

  implementation(platform(libs.androidxComposeBom))
  implementation(libs.androidxNavigationCompose)
  implementation(libs.hiltAndroid)
  implementation(libs.material)

  ksp(libs.hiltCompiler)
}
