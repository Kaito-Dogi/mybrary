package app.doggy.mybrary.core.data.repository

import app.doggy.mybrary.core.data.model.dummyBooks
import app.doggy.mybrary.core.domain.model.Book
import app.doggy.mybrary.core.domain.repository.BookRepository
import app.doggy.mybrary.core.domain.repository.OrderType
import app.doggy.mybrary.core.domain.repository.PrintType
import javax.inject.Inject

internal class DebugBookRepository @Inject constructor() : BookRepository {
  override suspend fun searchBooks(
    keyword: String,
    maxResults: Int,
    startIndex: Int,
    orderBy: OrderType,
    printType: PrintType,
  ): List<Book> {
    return dummyBooks
      .subList(
        fromIndex = startIndex,
        toIndex = startIndex + maxResults,
      )
  }
}
