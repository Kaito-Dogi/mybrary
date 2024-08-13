package app.kaito_dogi.mybrary.feature.auth

import kotlinx.serialization.Serializable

sealed interface AuthRoute {
  @Serializable
  data object Login : AuthRoute

  @Serializable
  data object SignUp : AuthRoute

  @Serializable
  data class VerifyOtp(
    val email: String,
  ) : AuthRoute
}
