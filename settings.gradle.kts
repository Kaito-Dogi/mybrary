pluginManagement {
  repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
  }
}

// JVM Toolchain（JDK 17）を自動でダウンロードできるようにする
plugins {
  id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
    google()
    mavenCentral()
  }
}

rootProject.name = "Mybrary"
include(":app")
include(":core:api")
include(":core:common")
include(":core:config")
include(":core:database")
include(":core:design-system")
include(":core:domain")
include(":core:repository")
include(":core:repository-mock")
include(":core:ui")
include(":feature:my-book")
include(":feature:search-book")
include(":feature:setting")
