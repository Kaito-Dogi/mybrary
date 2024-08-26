package app.kaito_dogi.mybrary.core.navigation

import kotlinx.serialization.Serializable

sealed interface MybraryRoute {
  @Serializable
  data object Auth : MybraryRoute

  @Serializable
  data object MyBook : MybraryRoute

  @Serializable
  data object SearchBook : MybraryRoute

  @Serializable
  data object SendOtp : MybraryRoute

  @Serializable
  data class VerifyOtp(
    val email: String,
    val page: Page,
  ) : MybraryRoute {
    enum class Page {
      Login,
      SignUp,
      ;
    }
  }
}
