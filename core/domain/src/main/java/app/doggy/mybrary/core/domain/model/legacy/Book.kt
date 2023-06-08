package app.doggy.mybrary.core.domain.model.legacy

import app.doggy.mybrary.core.domain.model.Diary
import java.util.Date

data class Book(
  val id: Long?,
  val booksApiId: String?,
  val title: String,
  val authors: List<String>,
  val description: String,
  val totalPage: Int,
  val imageUrl: String?,
  val diaries: List<Diary>,
  val registeredAt: Date?,
) {
  companion object {
    fun createEmpty() = Book(
      id = null,
      booksApiId = null,
      title = "",
      authors = listOf(),
      description = "",
      totalPage = 1,
      imageUrl = null,
      diaries = listOf(),
      registeredAt = null,
    )
  }

  fun getPercent(): Int {
    val currentPage =
      if (diaries.isNotEmpty()) diaries.last().currentPage
      else 0
    return 100 * currentPage / totalPage
  }
}
