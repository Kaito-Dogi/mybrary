package app.doggy.mybrary.core.data.legacy.fake

import app.doggy.mybrary.core.domain.model.legacy.LegacyBook
import app.doggy.mybrary.core.domain.model.legacy.LegacyDiary
import app.doggy.mybrary.core.domain.repository.legacy.LegacyBookRepository
import java.util.Date
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class FakeLegacyBookRepository @Inject constructor() : LegacyBookRepository {
  override suspend fun fetchBooksByIsbn(isbn: String): List<LegacyBook> = withContext(Dispatchers.IO) {
    delay(1000L)
    fakeBookList
  }

  override suspend fun getBooks(): List<LegacyBook> = withContext(Dispatchers.IO) {
    delay(1000L)
    fakeBookList
  }

  override suspend fun getBook(bookId: Long): LegacyBook = withContext(Dispatchers.IO) {
    delay(1000L)
    createFakeBook(1)
  }

  override suspend fun registerBook(legacyBook: LegacyBook): Boolean = withContext(Dispatchers.IO) {
    delay(1000L)
    true
  }
}

private fun createFakeBook(num: Int) = LegacyBook(
  id = num.toLong(),
  booksApiId = "4TKQswEACAAJ",
  title = "Kotlinイン・アクション",
  authors = listOf(
    "Dmitry Jemerov",
    "Svetlana Isakova",
  ),
  description = "Kotlinの開発者が全てのJavaディベロッパーに向けて、その導入から高度な利用法まで、徹底解説!",
  totalPage = 439 * num,
  imageUrl = when (num % 8) {
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
    LegacyDiary(
      content = "Kotlin の文法を学ぶことで、 Android アプリプログラミングの理解が深まった。",
      currentPage = 100,
      recordedAt = Date(),
    ),
    LegacyDiary(
      content = "data class は便利だなぁ。",
      currentPage = 200,
      recordedAt = Date(),
    ),
    LegacyDiary(
      content = "コレクションをもっと使いこなしたい!",
      currentPage = 300,
      recordedAt = Date(),
    ),
  ),
  registeredAt = Date(),
)

private val fakeBookList = (1..14).map { num -> createFakeBook(num) }