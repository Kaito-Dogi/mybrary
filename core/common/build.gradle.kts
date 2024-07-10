plugins {
  alias(libs.plugins.javaLibrary)
  alias(libs.plugins.jetbrainsKotlinJvm)
  alias(libs.plugins.serialization)
  alias(libs.plugins.kotlinKapt)
}

java {
  sourceCompatibility = JavaVersion.VERSION_17
  targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
  implementation(libs.hiltCore)
  implementation(libs.kotlinxCoroutinesCore)
  implementation(libs.serialization)

  kapt(libs.hiltCompiler)
}

kapt {
  correctErrorTypes = true
}
