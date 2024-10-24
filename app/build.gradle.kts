import com.android.build.api.dsl.VariantDimension
import java.util.Properties

private val properties = Properties()
private val secretsProperties = rootProject.file("./secrets.properties")
if (secretsProperties.exists()) {
  properties.load(secretsProperties.inputStream())
}

private fun VariantDimension.buildConfigStringField(
  name: String,
  value: String?,
  initialValue: String,
) = this.buildConfigField(
  type = "String",
  name = name,
  value = value?.let { "\"$it\"" } ?: initialValue,
)

private fun getEnvOrEmpty(name: String) = "\"${System.getenv(name)}\""

plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.compose)
  alias(libs.plugins.hilt.android)
  alias(libs.plugins.kotlin.android)
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

    buildConfigStringField(
      name = "DELETE_ACCOUNT_URL",
      value = properties.getProperty("deleteAccountUrl"),
      initialValue = getEnvOrEmpty(name = "DELETE_ACCOUNT_URL"),
    )
    buildConfigStringField(
      name = "HCAPTCHA_SITE_KEY",
      value = properties.getProperty("hCaptcha.siteKey.dev"),
      initialValue = getEnvOrEmpty(name = "HCAPTCHA_SITE_KEY_DEV"),
    )
    buildConfigStringField(
      name = "PRIVACY_POLICY_URL",
      value = properties.getProperty("privacyPolicyUrl"),
      initialValue = getEnvOrEmpty(name = "PRIVACY_POLICY_URL"),
    )
    buildConfigStringField(
      name = "RAKUTEN_AFFILIATE_ID",
      value = properties.getProperty("rakuten.affiliateId.dev"),
      initialValue = getEnvOrEmpty(name = "RAKUTEN_AFFILIATE_ID_DEV"),
    )
    buildConfigStringField(
      name = "RAKUTEN_APPLICATION_ID",
      value = properties.getProperty("rakuten.applicationId.dev"),
      initialValue = getEnvOrEmpty(name = "RAKUTEN_APPLICATION_ID_DEV"),
    )
    buildConfigStringField(
      name = "RAKUTEN_DEVELOPERS_URL",
      value = properties.getProperty("rakuten.developersUrl"),
      initialValue = getEnvOrEmpty(name = "RAKUTEN_DEVELOPERS_URL"),
    )
    buildConfigStringField(
      name = "SUPABASE_KEY",
      value = properties.getProperty("supabase.key.dev"),
      initialValue = getEnvOrEmpty(name = "SUPABASE_KEY_DEV"),
    )
    buildConfigStringField(
      name = "SUPABASE_URL",
      value = properties.getProperty("supabase.url.dev"),
      initialValue = getEnvOrEmpty(name = "SUPABASE_URL_DEV"),
    )
    buildConfigStringField(
      name = "TERMS_OF_USE",
      value = properties.getProperty("termsOfUseUrl"),
      initialValue = getEnvOrEmpty(name = "TERMS_OF_USE"),
    )
    buildConfigStringField(
      name = "VERSION_NAME",
      value = versionName,
      initialValue = "",
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

      buildConfigStringField(
        name = "HCAPTCHA_SITE_KEY",
        value = properties.getProperty("hCaptcha.siteKey.prod"),
        initialValue = getEnvOrEmpty(name = "HCAPTCHA_SITE_KEY_PROD"),
      )
      buildConfigStringField(
        name = "RAKUTEN_AFFILIATE_ID",
        value = properties.getProperty("rakuten.affiliateId.prod"),
        initialValue = getEnvOrEmpty(name = "RAKUTEN_AFFILIATE_ID_PROD"),
      )
      buildConfigStringField(
        name = "RAKUTEN_APPLICATION_ID",
        value = properties.getProperty("rakuten.applicationId.prod"),
        initialValue = getEnvOrEmpty(name = "RAKUTEN_APPLICATION_ID_PROD"),
      )
      buildConfigStringField(
        name = "SUPABASE_KEY",
        value = properties.getProperty("supabase.key.prod"),
        initialValue = getEnvOrEmpty(name = "SUPABASE_KEY_PROD"),
      )
      buildConfigStringField(
        name = "SUPABASE_URL",
        value = properties.getProperty("supabase.url.prod"),
        initialValue = getEnvOrEmpty(name = "SUPABASE_URL_PROD"),
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
}

dependencies {
  implementation(project(":core:api"))
  implementation(project(":core:common"))
  implementation(project(":core:config"))
  implementation(project(":core:data"))
  implementation(project(":core:database"))
  implementation(project(":core:design-system"))
  implementation(project(":core:domain"))
  implementation(project(":core:hcaptcha"))
  implementation(project(":core:supabase"))
  implementation(project(":core:ui"))
  implementation(project(":feature:my-book"))
  implementation(project(":feature:search-book"))
  implementation(project(":feature:setting"))
  implementation(project(":feature:sign-in"))
  implementation(project(":feature:sign-up"))
  implementation(project(":feature:verify-otp"))

  "prodImplementation"((project(":core:repository")))
  "devImplementation"((project(":core:repository")))
  "mockImplementation"((project(":core:repository-mock")))

  implementation(libs.android.material)
  implementation(platform(libs.androidx.compose.bom))
  implementation(libs.androidx.navigation.compose)
  implementation(libs.hilt.android)

  ksp(libs.hilt.android.compiler)
}
