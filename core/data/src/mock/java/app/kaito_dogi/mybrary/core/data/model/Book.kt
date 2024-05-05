package app.kaito_dogi.mybrary.core.data.model

import app.kaito_dogi.mybrary.core.domain.model.Book

internal val dummyBooks = buildList {
  repeat(20) {
    add(
      Book(
        id = "Book$it",
        title = "Book$it",
        author = "Book$it",
        imageUrl = "Book$it",
      ),
    )
  }
}
