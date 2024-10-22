package app.kaito_dogi.mybrary.core.ui.navigation.route

import kotlinx.serialization.Serializable

sealed interface AuthRoute {
  @Serializable
  data class VerifyOtp(
    val email: String,
    val page: Page,
  ) : AuthRoute {
    enum class Page {
      SignIn,
      SignUp,
    }
  }

  @Serializable
  data object SignIn : AuthRoute

  @Serializable
  data object SignUp : AuthRoute
}
