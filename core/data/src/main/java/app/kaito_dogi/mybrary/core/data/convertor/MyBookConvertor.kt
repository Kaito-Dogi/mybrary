package app.kaito_dogi.mybrary.core.data.convertor

import app.kaito_dogi.mybrary.core.api.mybrary.response.model.MyBookResponse
import app.kaito_dogi.mybrary.core.common.model.Url
import app.kaito_dogi.mybrary.core.domain.model.BookId
import app.kaito_dogi.mybrary.core.domain.model.MyBook
import app.kaito_dogi.mybrary.core.domain.model.MyBookId

internal fun MyBookResponse.toMyBook() = MyBook(
  id = MyBookId(value = this.id),
  // user = this.user.toUser(),
  bookId = BookId(value = this.bookId),
  title = this.book.title,
  imageUrl = this.book.imageUrl.let { Url.Image(value = it) },
  isbn = this.book.isbn,
  publisher = this.book.publisher,
  authorList = this.book.authors.toAuthorList(),
  genre = this.book.genre.toGenre(),
  isPinned = isPinned,
  isFavorite = isFavorite,
  isPublic = isPublic,
  isArchived = isArchived,
)
