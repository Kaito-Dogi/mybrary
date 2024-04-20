package app.doggy.mybrary.core.database.entity

import androidx.room.Embedded
import androidx.room.Relation

data class BookWithAuthors(
  @Embedded val book: BookEntity,
  @Relation(
    entity = AuthorEntity::class,
    parentColumn = "id",
    entityColumn = "book_id",
  ) val authors: List<AuthorEntity>,
)
