package app.doggy.core.database.entity

import androidx.room.Embedded
import androidx.room.Relation
import app.doggy.core.common.util.UnixTime
import app.doggy.mybrary.core.domain.model.book.Book
import app.doggy.mybrary.core.domain.model.book.BookId
import app.doggy.mybrary.core.domain.model.book.BookTotalPage

data class BookWithAuthors(
  @Embedded val book: BookEntity,
  @Relation(
    entity = AuthorEntity::class,
    parentColumn = "id",
    entityColumn = "book_id",
  ) val authors: List<AuthorEntity>,
) {
  fun toBook() = Book(
    id = BookId(book.id),
    title = book.title,
    description = book.description,
    totalPage = BookTotalPage(book.totalPage),
    imageUrl = book.imageUrl,
    registeredAt = UnixTime(book.registeredAt),
    isPinned = book.isPinned,
    authors = authors.map { it.toAuthor() },
    status = book.status,
  )
}

fun Book.toBookWithAuthors() = BookWithAuthors(
  book = this.toEntity(),
  authors = this.authors.map {
    it.toEntity(this.id)
  },
)
