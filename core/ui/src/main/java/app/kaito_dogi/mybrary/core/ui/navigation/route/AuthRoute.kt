package app.kaito_dogi.mybrary.core.ui.navigation.route

import kotlinx.serialization.Serializable

sealed interface AuthRoute {
  @Serializable
  data object SignIn : AuthRoute

  @Serializable
  data object SignUp : AuthRoute

  @Serializable
  data class VerifyOtp(
    val email: String,
    val source: Source,
  ) : AuthRoute {
    enum class Source {
      SignIn,
      SignUp,
    }
  }
}
