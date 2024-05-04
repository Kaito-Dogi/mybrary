package app.kaito_dogi.mybrary.core.data.model

import app.kaito_dogi.mybrary.core.domain.model.Memo
import app.kaito_dogi.mybrary.core.domain.model.MemoId
import app.kaito_dogi.mybrary.core.domain.model.MyBookId
import java.util.Date

internal val dummyMemos = buildList {
  repeat(20) { myBookIndex ->
    repeat(10) { memoIndex ->
      add(
        Memo(
          id = MemoId(memoIndex.toLong()),
          myBookId = MyBookId(myBookIndex.toLong()),
          content = "Memo$memoIndex",
          fromPage = null,
          toPage = null,
          createdAt = Date(),
          isPosted = false,
          postedAt = null,
          likeCount = null,
        ),
      )
    }
  }
}
