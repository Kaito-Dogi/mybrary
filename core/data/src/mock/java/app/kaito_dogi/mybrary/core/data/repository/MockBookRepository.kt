package app.kaito_dogi.mybrary.core.data.repository

import app.kaito_dogi.mybrary.core.api.rakuten.RakutenApi
import app.kaito_dogi.mybrary.core.domain.model.Book
import app.kaito_dogi.mybrary.core.domain.model.BookId
import app.kaito_dogi.mybrary.core.domain.repository.BookRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class MockBookRepository @Inject constructor(
  private val rakutenApi: RakutenApi,
) : BookRepository {
  override suspend fun getBook(id: BookId): Book {
    TODO("Not yet implemented")
  }

  override suspend fun searchBook(
    title: String,
    size: Int,
    isbn: String,
    genre: Genre,
    hits: Int,
    page: Int,
    sort: String,
  ): List<Book> {
    // TODO: MockMyBookRepository と同様に mockBookList を実装する
    TODO("Not yet implemented")
    sort: Sort,
  }
}
