package app.doggy.newmybrary.data.repository

import app.doggy.newmybrary.domain.model.Book
import app.doggy.newmybrary.domain.model.Diary
import app.doggy.newmybrary.domain.repository.BookRepository
import java.util.Date
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class FakeBookRepository @Inject constructor() : BookRepository {
  override suspend fun fetchBooksByIsbn(isbn: String): List<Book> = withContext(Dispatchers.IO) {
    delay(1000L)
    fakeBookList
  }

  override suspend fun getBooks(): List<Book> = withContext(Dispatchers.IO) {
    delay(1000L)
    fakeBookList
  }

  override suspend fun registerBook(book: Book): Boolean = withContext(Dispatchers.IO) {
    delay(1000L)
    true
  }
}

private val fakeBookList = (1..7).map { index ->
  Book(
    id = index.toLong(),
    booksApiId = index.toString(),
    title = index.toString(),
    authors = listOf(
      index.toString(),
    ),
    description = index.toString(),
    totalPage = index,
    imageUrl = index.toString(),
    diaryList = listOf(
      Diary(
        content = index.toString(),
        currentPage = index - 1,
        recordedAt = Date(),
      ),
    ),
    registeredAt = Date(),
  )
}
