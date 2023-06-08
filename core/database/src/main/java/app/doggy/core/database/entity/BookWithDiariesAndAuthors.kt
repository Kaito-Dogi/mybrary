package app.doggy.core.database.entity

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import app.doggy.mybrary.core.domain.model.legacy.Book

data class BookWithDiariesAndAuthors(
  @Embedded val book: BookEntity,
  @Relation(
    parentColumn = "book_id",
    entityColumn = "author_id",
    associateBy = Junction(BookAuthorCrossRef::class),
  )
  val authors: List<AuthorEntity>,
  @Relation(
    entity = DiaryEntity::class,
    parentColumn = "book_id",
    entityColumn = "book_id",
  )
  val diaries: List<DiaryEntity>,
) {
  // FIXME: 変換メソッドの置き場を考える
  fun toBook() = Book(
    id = book.bookId,
    booksApiId = book.booksApiId,
    title = book.title,
    authors = authors.map { it.name },
    description = book.description,
    totalPage = book.totalPage,
    imageUrl = book.imageUrl,
    diaries = diaries.map { it.toDiary() },
    registeredAt = book.createdAt,
  )
}
