package app.doggy.core.database.entity

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class BookWithAuthors(
  @Embedded val book: BookEntity,
  @Relation(
    entity = AuthorEntity::class,
    parentColumn = "id",
    entityColumn = "id",
    associateBy = Junction(
      BookAuthorCrossRef::class,
      parentColumn = "book_id",
      entityColumn = "author_id",
    ),
  )
  val authors: List<AuthorEntity>,
)
