package app.kaito_dogi.mybrary.core.data.dto

import app.kaito_dogi.mybrary.core.common.model.Url
import app.kaito_dogi.mybrary.core.domain.model.MyBook
import app.kaito_dogi.mybrary.core.domain.model.MyBookId

data class MyBookDto(
  val id: String,
  val title: String,
  val imageUrl: String,
  val authors: AuthorsDto,
  val publisher: String,
  val isbn: String,
  val genre: GenreDto,
  val isPinned: Boolean,
  val isFavorite: Boolean,
  val isPublic: Boolean,
  val isArchived: Boolean,
) {
  fun toMyBook() = MyBook(
    id = MyBookId(value = this.id),
    title = this.title,
    imageUrl = this.imageUrl.let { Url.Image(value = it) },
    authorList = this.authors.toAuthorList(),
    publisher = this.publisher,
    isbn = this.isbn,
    genre = this.genre.toGenre(),
    isPinned = this.isPinned,
    isFavorite = this.isFavorite,
    isPublic = this.isPublic,
    isArchived = this.isArchived,
  )
}
