plugins {
  alias(libs.plugins.javaLibrary)
  alias(libs.plugins.jetbrainsKotlinJvm)
  alias(libs.plugins.ksp)
  alias(libs.plugins.serialization)
}

java {
  sourceCompatibility = JavaVersion.VERSION_17
  targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
  implementation(libs.hilt.core)
  implementation(libs.kotlinx.coroutines.core)
  implementation(libs.kotlinx.serialization)

  ksp(libs.hilt.android.compiler)
}
