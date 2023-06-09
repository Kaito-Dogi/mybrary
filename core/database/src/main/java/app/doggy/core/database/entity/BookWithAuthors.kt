package app.doggy.core.database.entity

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class BookWithAuthors(
  @Embedded val book: BookEntity,
  @Relation(
    parentColumn = "id",
    entityColumn = "id",
    associateBy = Junction(BookAuthorCrossRef::class),
  )
  val authors: List<AuthorEntity>,
)
