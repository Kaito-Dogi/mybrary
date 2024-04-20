package app.doggy.mybrary.core.data.model

import app.doggy.mybrary.core.domain.model.DraftMemo
import app.doggy.mybrary.core.domain.model.MyBookId

internal val dummyDraftMemos = buildList {
  repeat(20) {
    add(
      DraftMemo(
        myBookId = MyBookId(it.toLong()),
        content = "DraftMemo$it",
        fromPage = null,
        toPage = null,
      ),
    )
  }
}
