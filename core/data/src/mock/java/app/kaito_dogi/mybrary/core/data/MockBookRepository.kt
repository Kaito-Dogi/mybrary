package app.kaito_dogi.mybrary.core.data

import app.kaito_dogi.mybrary.core.common.coroutines.MybraryDispatcher
import app.kaito_dogi.mybrary.core.common.coroutines.MybraryDispatchers
import app.kaito_dogi.mybrary.core.common.model.Url
import app.kaito_dogi.mybrary.core.data.convertor.toAuthorList
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
  @MybraryDispatcher(MybraryDispatchers.Io) private val dispatcher: CoroutineDispatcher,
) : BookRepository {
  override suspend fun getBook(id: BookId): Book = withContext(dispatcher) {
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

    return@withContext MockBookList
  }
}


private val MockBookList = List(10) { index ->
  Book(
    id = BookId(value = "$index"),
    title = when (index % 3) {
      0 -> "ピンポン（1）"
      1 -> "ピンポン（2）"
      else -> "ピンポン（3）"
    },
    imageUrl = when (index % 3) {
      0 -> Url.Image(value = "https://thumbnail.image.rakuten.co.jp/@0_mall/book/cabinet/2416/9784091962416.jpg?_ex=512x512")
      1 -> Url.Image(value = "https://thumbnail.image.rakuten.co.jp/@0_mall/book/cabinet/2423/9784091962423.jpg?_ex=512x512")
      else -> Url.Image(value = "https://thumbnail.image.rakuten.co.jp/@0_mall/book/cabinet/2430/9784091962430.jpg?_ex=512x512")
    },
    isbn = "isbn$index",
    publisher = "小学館",
    authorList = "松本 大洋".toAuthorList(),
    genre = Genre.Paperback,
    rakutenAffiliateUrl = Url.Affiliate(value = "rakutenAffiliateUrl$index"),
    amazonAffiliateUrl = null,
  )
}
