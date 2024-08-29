package app.kaito_dogi.mybrary.core.data.repository

import app.kaito_dogi.mybrary.core.common.coroutines.dispatcher.Dispatcher
import app.kaito_dogi.mybrary.core.common.coroutines.dispatcher.MybraryDispatchers
import app.kaito_dogi.mybrary.core.common.model.Url
import app.kaito_dogi.mybrary.core.domain.model.Author
import app.kaito_dogi.mybrary.core.domain.model.Book
import app.kaito_dogi.mybrary.core.domain.model.BookId
import app.kaito_dogi.mybrary.core.domain.model.Genre
import app.kaito_dogi.mybrary.core.domain.model.Sort
import app.kaito_dogi.mybrary.core.domain.repository.BookRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

@Singleton
internal class MockBookRepository @Inject constructor(
  @Dispatcher(MybraryDispatchers.IO) private val dispatcher: CoroutineDispatcher,
) : BookRepository {
  override suspend fun getBook(id: BookId): Book {
    TODO("Not yet implemented")
  }

  override suspend fun searchBook(
    title: String?,
    isbn: String?,
    author: String?,
    publisher: String?,
    genre: Genre,
    hits: Int,
    page: Int,
    sort: Sort,
  ): List<Book> = withContext(dispatcher) {
    delay(1_000)

    return@withContext MockMyBookList
  }
}

private val MockMyBookList = List(10) { index ->
  Book(
    id = BookId(value = "$index"),
    title = "title$index",
    imageUrl = Url.Image(value = "imageUrl$index"),
    isbn = "isbn$index",
    publisher = "publisher$index",
    authorList = listOf(Author(name = "author$index")),
    genre = Genre.All,
  )
}
