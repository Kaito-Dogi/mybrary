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
}

private val fakeBookList = listOf(
  Book(
    id = "1",
    title = "1",
    authors = listOf(
      "1",
    ),
    description = "1",
    totalPage = 1,
    imageUrl = "1",
    diaryList = listOf(
      Diary(
        content = "1",
        currentPage = 0,
        recordedAt = Date(),
      ),
    ),
    registeredAt = Date(),
  ),
  Book(
    id = "2",
    title = "2",
    authors = listOf(
      "2",
    ),
    description = "2",
    totalPage = 2,
    imageUrl = "",
    diaryList = listOf(
      Diary(
        content = "2",
        currentPage = 1,
        recordedAt = Date(),
      ),
    ),
    registeredAt = Date(),
  ),
  Book(
    id = "3",
    title = "3",
    authors = listOf(
      "3",
    ),
    description = "3",
    totalPage = 3,
    imageUrl = "3",
    diaryList = listOf(
      Diary(
        content = "3",
        currentPage = 2,
        recordedAt = Date(),
      ),
    ),
    registeredAt = Date(),
  ),
  Book(
    id = "4",
    title = "4",
    authors = listOf(
      "4",
    ),
    description = "4",
    totalPage = 4,
    imageUrl = "4",
    diaryList = listOf(
      Diary(
        content = "4",
        currentPage = 3,
        recordedAt = Date(),
      ),
    ),
    registeredAt = Date(),
  ),
  Book(
    id = "5",
    title = "5",
    authors = listOf(
      "5",
    ),
    description = "5",
    totalPage = 5,
    imageUrl = "5",
    diaryList = listOf(
      Diary(
        content = "5",
        currentPage = 4,
        recordedAt = Date(),
      ),
    ),
    registeredAt = Date(),
  ),
  Book(
    id = "6",
    title = "6",
    authors = listOf(
      "6",
    ),
    description = "6",
    totalPage = 6,
    imageUrl = "6",
    diaryList = listOf(
      Diary(
        content = "6",
        currentPage = 5,
        recordedAt = Date(),
      ),
    ),
    registeredAt = Date(),
  ),
  Book(
    id = "7",
    title = "7",
    authors = listOf(
      "7",
    ),
    description = "7",
    totalPage = 7,
    imageUrl = "",
    diaryList = listOf(
      Diary(
        content = "7",
        currentPage = 6,
        recordedAt = Date(),
      ),
    ),
    registeredAt = Date(),
  ),
)
