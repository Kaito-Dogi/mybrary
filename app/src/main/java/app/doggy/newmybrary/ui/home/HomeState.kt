package app.doggy.newmybrary.ui.home

data class HomeState(
  val uiModelList: List<HomeUiModel>,
  val isLoading: Boolean,
) {
  companion object {
    fun initial() = HomeState(
      uiModelList = listOf(),
      isLoading = false,
    )
  }
}
