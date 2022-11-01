package app.doggy.newmybrary

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.Date
import java.util.UUID

open class BookEntity(
  @PrimaryKey open var id: String = UUID.randomUUID().toString(),
  open var imageId: String = "",
  open var title: String = "",
  open var author: String = "",
  open var pageCount: Int = 1,
  open var currentPage: Int = 0,
  open var description: String = "",
  open var createdAt: Date = Date(System.currentTimeMillis()),
) : RealmObject()
