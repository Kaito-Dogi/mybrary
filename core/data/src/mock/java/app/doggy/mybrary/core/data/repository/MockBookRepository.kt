package app.kaito_dogi.mybrary.core.data.repository

import app.kaito_dogi.mybrary.core.data.model.dummyBooks
import app.kaito_dogi.mybrary.core.domain.model.Book
import app.kaito_dogi.mybrary.core.domain.repository.BookRepository
import app.kaito_dogi.mybrary.core.domain.repository.OrderType
import app.kaito_dogi.mybrary.core.domain.repository.PrintType
import javax.inject.Inject

internal class MockBookRepository @Inject constructor() : BookRepository {
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
