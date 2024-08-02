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
  implementation(libs.hiltCore)
  implementation(libs.kotlinxCoroutinesCore)
  implementation(libs.serialization)

  ksp(libs.hiltCompiler)
}
