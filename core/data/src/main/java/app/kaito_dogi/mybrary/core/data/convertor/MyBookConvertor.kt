package app.kaito_dogi.mybrary.core.data.convertor

import app.kaito_dogi.mybrary.core.api.mybrary.response.model.AuthorResponse
import app.kaito_dogi.mybrary.core.api.mybrary.response.model.MyBookResponse
import app.kaito_dogi.mybrary.core.common.model.Url
import app.kaito_dogi.mybrary.core.domain.model.BookId
import app.kaito_dogi.mybrary.core.domain.model.ExternalBookId
import app.kaito_dogi.mybrary.core.domain.model.MyBook
import app.kaito_dogi.mybrary.core.domain.model.MyBookId

internal fun MyBookResponse.toMyBook() = MyBook(
  id = MyBookId(value = this.id),
  user = this.user.toUser(),
  bookId = BookId(value = this.bookId),
  externalId = ExternalBookId(value = this.book.externalId),
  title = this.book.title,
  imageUrl = this.book.imageUrl?.let { Url.Image(value = it) },
  isbn10 = this.book.isbn10,
  isbn13 = this.book.isbn13,
  pageCount = this.book.pageCount,
  publisher = this.book.publisher,
  authors = this.book.authors.map(AuthorResponse::toAuthor),
  isPinned = isPinned,
  isFavorite = isFavorite,
  isPublic = isPublic,
  isArchived = isArchived,
)
