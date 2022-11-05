package app.doggy.newmybrary.ui.book.register

data class RegisterState(
  val isLoading: Boolean,
) {
  companion object {
    fun initial() = RegisterState(
      isLoading = false,
    )
  }
}
