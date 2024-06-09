package app.kaito_dogi.mybrary.core.data.model

import app.kaito_dogi.mybrary.core.common.model.Url
import app.kaito_dogi.mybrary.core.domain.model.Book

internal val dummyBooks = buildList {
  repeat(20) {
    add(
      Book(
        id = "id: $it",
        title = "title: $it",
        authors = "authors: $it",
        imageUrl = Url.Image(value = "imageUrl: $it"),
      ),
    )
  }
}
