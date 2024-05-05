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
        imageUrl = when (myBookIndex % 7) {
          0 -> "https://books.google.com/books/content?id=RuKoDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
          1 -> "https://books.google.com/books/content?id=SinFRfuTH7IC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
          2 -> "https://books.google.com/books/content?id=1FGpzQEACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api"
          3 -> "https://books.google.com/books/content?id=IUp4CwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
          4 -> "https://books.google.com/books/content?id=1f9lDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
          5 -> "https://books.google.com/books/content?id=4TKQswEACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api"
          else -> ""
        },
        isPinned = false,
        isFavorite = false,
        isArchived = false,
        memos = dummyMemos.filter { it.myBookId == myBookId },
      ),
    )
  }
}
