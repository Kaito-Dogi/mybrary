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
  user = this.userResponse.toUser(),
  bookId = BookId(value = this.bookId),
  externalId = ExternalBookId(value = this.bookResponse.externalId),
  title = this.bookResponse.title,
  imageUrl = this.bookResponse.imageUrl?.let { Url.Image(value = it) },
  isbn10 = this.bookResponse.isbn10,
  isbn13 = this.bookResponse.isbn13,
  pageCount = this.bookResponse.pageCount,
  publisher = this.bookResponse.publisher,
  authors = this.bookResponse.authors.map(AuthorResponse::toAuthor),
  isPinned = isPinned,
  isFavorite = isFavorite,
  isPublic = isPublic,
  isArchived = isArchived,
)
