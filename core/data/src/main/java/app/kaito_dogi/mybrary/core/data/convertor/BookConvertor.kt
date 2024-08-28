package app.kaito_dogi.mybrary.core.data.convertor

import app.kaito_dogi.mybrary.core.api.rakuten.response.ItemResponse
import app.kaito_dogi.mybrary.core.common.model.Url
import app.kaito_dogi.mybrary.core.domain.model.Author
import app.kaito_dogi.mybrary.core.domain.model.AuthorId
import app.kaito_dogi.mybrary.core.domain.model.Book
import app.kaito_dogi.mybrary.core.domain.model.BookId

internal fun ItemResponse.toBook() = Book(
  id = BookId(value = 0L),
  title = this.title,
  imageUrl = Url.Image(
    value = this.smallImageUrl
      .replace(
        oldValue = "64x64",
        newValue = "512x512",
      ),
  ),
  isbn = this.isbn,
  publisher = this.publisherName,
  authors = this.author
    .split("/")
    .map {
      Author(
        id = AuthorId(value = 0L),
        name = it,
      )
    },
)
