package app.kaito_dogi.mybrary.core.data.convertor

import app.kaito_dogi.mybrary.core.api.mybrary.response.model.BookResponse
import app.kaito_dogi.mybrary.core.api.rakuten.response.ItemResponse
import app.kaito_dogi.mybrary.core.common.model.Url
import app.kaito_dogi.mybrary.core.domain.model.Book
import app.kaito_dogi.mybrary.core.domain.model.BookId

internal fun BookResponse.toBook() = Book(
  id = BookId(value = ""),
  title = this.title,
  imageUrl = Url.Image(value = this.imageUrl),
  isbn = this.isbn,
  publisher = this.publisher,
  authorList = this.authors.toAuthorList(),
  genre = this.genre.toGenre(),
)

internal fun ItemResponse.toBook() = Book(
  id = BookId(value = ""),
  title = this.title,
  imageUrl = Url.Image(
    value = this.smallImageUrl.replace(
      oldValue = "64x64",
      newValue = "512x512",
    ),
  ),
  isbn = this.isbn,
  publisher = this.publisherName,
  authorList = this.author.toAuthorList(),
  genre = this.size.toGenre(),
)
