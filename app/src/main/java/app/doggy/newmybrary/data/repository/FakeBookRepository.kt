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

private val fakeBookList = (1..14).map { index ->
  Book(
    id = index.toLong(),
    booksApiId = index.toString(),
    title = index.toString(),
    authors = listOf(
      index.toString(),
    ),
    description = index.toString(),
    totalPage = index,
    imageUrl = when (index % 8) {
      0 -> "http://books.google.com/books/content?id=cJD9vQAACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api" // Kotlinスタートブック
      1 -> "http://books.google.com/books/content?id=E323DwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api" // Kotlinイン・アクション
      2 -> "http://books.google.com/books/content?id=GRjUuQEACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api" // Clean Architecture 達人に学ぶソフトウェアの構造と設計
      3 -> "http://books.google.com/books/content?id=Wx1dLwEACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api" // リーダブルコード
      4 -> "http://books.google.com/books/content?id=biseDAAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api" // プリンシプル オブ プログラミング
      5 -> "http://books.google.com/books/content?id=c4bnSAAACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api" // Webを支える技術
      6 -> "http://books.google.com/books/content?id=01LADwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api" // マスタリングTCP/IP
      else -> null
    },
    diaries = listOf(
      Diary(
        content = index.toString(),
        currentPage = index - 1,
        recordedAt = Date(),
      ),
    ),
    registeredAt = Date(),
  )
}
