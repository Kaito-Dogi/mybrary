package app.doggy.newmybrary.ui.home

data class HomeState(
  val uiModels: List<HomeUiModel>,
  val isLoading: Boolean,
) {
  companion object {
    fun initial() = HomeState(
      uiModels = listOf(),
      isLoading = false,
    )
  }
}
