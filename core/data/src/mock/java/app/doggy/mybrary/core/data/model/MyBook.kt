package app.kaito_dogi.mybrary.core.data.model

import app.kaito_dogi.mybrary.core.domain.model.MyBook
import app.kaito_dogi.mybrary.core.domain.model.MyBookId

internal val dummyMyBooks = buildList {
  repeat(20) { myBookIndex ->
    val myBookId = MyBookId(myBookIndex.toLong())
    add(
      MyBook(
        id = myBookId,
        externalId = "MyBook$myBookId",
        title = "MyBook$myBookId",
        author = "MyBook$myBookId",
        imageUrl = "MyBook$myBookId",
        isPinned = false,
        isFavorite = false,
        isArchived = false,
        memos = dummyMemos.filter { it.myBookId == myBookId },
      ),
    )
  }
}
