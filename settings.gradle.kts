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
include(":core:designsystem")
include(":core:domain")
include(":core:supabase")
include(":core:ui")
include(":feature:login")
include(":feature:mybookdetail")
include(":feature:mybooklist")
include(":feature:searchbook")
