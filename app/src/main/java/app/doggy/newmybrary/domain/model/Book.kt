package app.doggy.newmybrary.domain.model

import app.doggy.newmybrary.data.api.response.FetchBooksResponseItem
import java.util.Date

data class Book(
  val id: String,
  val title: String,
  val author: List<String>,
  val description: String,
  val totalPage: Int,
  val imageUrl: String,
  val recordList: List<Diary>,
  val registeredAt: Date?,
)

fun FetchBooksResponseItem.toBook() = Book(
  id = this.id,
  title = this.volumeInfo.title,
  author = this.volumeInfo.authors,
  description = this.volumeInfo.description,
  totalPage = this.volumeInfo.pageCount,
  imageUrl = this.volumeInfo.imageLinks.thumbnail,
  recordList = listOf(),
  registeredAt = null
)
