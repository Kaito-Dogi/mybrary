package app.doggy.newmybrary.ui.home

import com.xwray.groupie.GroupieAdapter

class HomeAdapter : GroupieAdapter() {
  fun update(uiModels: List<HomeUiModel>) {
    update(
      uiModels.map { uiModel ->
        when (uiModel) {
          is HomeUiModel.BookUiModel -> BookItem(uiModel)
        }
      },
    )
  }
}
