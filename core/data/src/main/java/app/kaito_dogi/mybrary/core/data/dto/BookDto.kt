package app.kaito_dogi.mybrary.core.data.dto

import app.kaito_dogi.mybrary.core.common.model.Url
import app.kaito_dogi.mybrary.core.domain.model.Book
import app.kaito_dogi.mybrary.core.domain.model.BookId

data class BookDto(
  val bookId: String,
  val title: String,
  val imageUrl: String,
  val authors: String,
  val publisher: String,
  val isbn: String,
  val genre: GenreDto,
  val rakutenUrl: String,
  val amazonUrl: String?,
) {
  fun toBook() = Book(
    id = BookId(value = bookId),
    title = this.title,
    imageUrl = Url.Image(value = this.imageUrl),
    isbn = this.isbn,
    publisher = this.publisher,
    authorList = this.authors.toAuthorList(),
    genre = this.genre.toGenre(),
    rakutenUrl = Url.Affiliate(value = this.rakutenUrl),
    amazonUrl = this.amazonUrl?.let { Url.Affiliate(value = it) },
  )
}
