package app.doggy.core.database.entity

import androidx.room.Embedded
import androidx.room.Relation

data class BookWithAuthorsWithRecords(
  @Embedded val book: BookEntity,
  @Relation(
    entity = AuthorEntity::class,
    parentColumn = "id",
    entityColumn = "book_id",
  )
  val authors: List<AuthorEntity>,
  @Relation(
    entity = RecordEntity::class,
    parentColumn = "id",
    entityColumn = "book_id",
  )
  val records: List<RecordEntity>,
)
