package app.doggy.newmybrary.domain.model

import java.util.Date

data class Book(
  val id: Long?,
  val booksApiId: String?,
  val title: String,
  val authors: List<String>,
  val description: String,
  val totalPage: Int,
  val imageUrl: String?,
  val diaryList: List<Diary>,
  val registeredAt: Date?,
) {
  fun getPercent(): Int {
    val currentPage =
      if (diaryList.isNotEmpty()) diaryList.last().currentPage
      else 0
    return 100 * currentPage / totalPage
  }
}
