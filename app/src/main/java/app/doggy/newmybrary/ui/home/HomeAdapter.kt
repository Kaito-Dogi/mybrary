package app.doggy.newmybrary.ui.home

import com.xwray.groupie.GroupieAdapter

class HomeAdapter : GroupieAdapter() {
  fun update(uiModelList: List<HomeUiModel>) {
    update(
      uiModelList.map { uiModel ->
        when (uiModel) {
          is HomeUiModel.BookUiModel -> BookItem(uiModel)
        }
      },
    )
  }
}
