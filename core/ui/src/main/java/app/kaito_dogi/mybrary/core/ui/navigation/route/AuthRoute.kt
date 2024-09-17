package app.kaito_dogi.mybrary.core.ui.navigation.route

import kotlinx.serialization.Serializable

sealed interface AuthRoute {
  @Serializable
  data object SendOtp : AuthRoute

  @Serializable
  data class VerifyOtp(
    val email: String,
    val page: Page,
  ) : AuthRoute {
    enum class Page {
      Login,
      SignUp,
    }
  }
}
