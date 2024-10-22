pluginManagement {
  repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
  }
}
dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
    google()
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
  }
}

rootProject.name = "Mybrary"
include(":app")
include(":core:api")
include(":core:common")
include(":core:config")
include(":core:data")
include(":core:database")
include(":core:design-system")
include(":core:domain")
include(":core:hcaptcha")
include(":core:repository")
include(":core:repository-mock")
include(":core:supabase")
include(":core:ui")
include(":feature:auth")
include(":feature:my-book")
include(":feature:search-book")
include(":feature:setting")
include(":feature:sign-in")
include(":feature:sign-up")
