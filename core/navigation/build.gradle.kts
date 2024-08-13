plugins {
  alias(libs.plugins.javaLibrary)
  alias(libs.plugins.jetbrainsKotlinJvm)
  alias(libs.plugins.serialization)
}

java {
  sourceCompatibility = JavaVersion.VERSION_17
  targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
  implementation(libs.androidxNavigationCompose)
  implementation(libs.serialization)
}
