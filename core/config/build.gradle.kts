plugins {
  alias(libs.plugins.java.library)
  alias(libs.plugins.jetbrains.kotlin.jvm)
}

java {
  sourceCompatibility = JavaVersion.VERSION_17
  targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
  jvmToolchain(libs.versions.jvmTarget.get().toInt())
}

dependencies {
  implementation(project(":core:common"))
}
