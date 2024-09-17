package app.kaito_dogi.mybrary.core.ui.navigation

import kotlinx.serialization.Serializable

@Deprecated("")
sealed interface MybraryRoute {
  @Serializable
  data object MyBookList : MybraryRoute

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
    }
  }
}
