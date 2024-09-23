plugins {
  alias(libs.plugins.javaLibrary)
  alias(libs.plugins.jetbrainsKotlinJvm)
}

java {
  sourceCompatibility = JavaVersion.VERSION_17
  targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
  implementation(project(":core:common"))
}
