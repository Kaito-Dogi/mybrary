package app.kaito_dogi.mybrary.core.data.model

import app.kaito_dogi.mybrary.core.domain.model.DraftMemo
import app.kaito_dogi.mybrary.core.domain.model.MyBookId

internal val dummyDraftMemos = buildList {
  repeat(20) {
    add(
      DraftMemo(
        myBookId = MyBookId(it.toLong()),
        content = "content: $it",
        fromPage = null,
        toPage = null,
      ),
    )
  }
}
