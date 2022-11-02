package app.doggy.newmybrary.data.db.entity

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class BookWithDiariesAndAuthors(
  @Embedded val book: BookEntity,
  @Relation(
    parentColumn = "book_id",
    entityColumn = "author_id",
    associateBy = Junction(BookAuthorCrossRef::class),
  )
  val authors: List<String>,
  @Relation(
    entity = DiaryEntity::class,
    parentColumn = "id",
    entityColumn = "book_id",
  )
  val diaries: List<DiaryEntity>,
)
