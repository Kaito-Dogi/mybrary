package app.kaito_dogi.mybrary.core.data.repository

import app.kaito_dogi.mybrary.core.common.coroutines.dispatcher.Dispatcher
import app.kaito_dogi.mybrary.core.common.coroutines.dispatcher.MybraryDispatchers
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
    imageUrl =
    when (index % 3) {
      0 -> Url.Image(value = "https://thumbnail.image.rakuten.co.jp/@0_mall/book/cabinet/2416/9784091962416.jpg?_ex=512x512")
      1 -> Url.Image(value = "https://thumbnail.image.rakuten.co.jp/@0_mall/book/cabinet/2423/9784091962423.jpg?_ex=512x512")
      else -> Url.Image(value = "https://thumbnail.image.rakuten.co.jp/@0_mall/book/cabinet/2430/9784091962430.jpg?_ex=512x512")
    },
    isbn = when (index % 5) {
      0 -> "9784091962416"
      1 -> "9784091962423"
      else -> "9784091962430"
    },
    publisher = "小学館",
    authorList = "松本 大洋".toAuthorList(),
    genre = Genre.Paperback,
    rakutenAffiliateUrl = when (index) {
      0 -> Url.Affiliate(value = "https://hb.afl.rakuten.co.jp/hgc/g00q072h.iz0yg250.g00q072h.iz0yhd2f/?pc=https%3A%2F%2Fbooks.rakuten.co.jp%2Frb%2F11778666%2F")
      1 -> Url.Affiliate(value = "https://hb.afl.rakuten.co.jp/hgc/g00q072h.iz0yg250.g00q072h.iz0yhd2f/?pc=https%3A%2F%2Fbooks.rakuten.co.jp%2Frb%2F11778667%2F")
      else -> Url.Affiliate(value = "https://hb.afl.rakuten.co.jp/hgc/g00q072h.iz0yg250.g00q072h.iz0yhd2f/?pc=https%3A%2F%2Fbooks.rakuten.co.jp%2Frb%2F11826794%2F")
    },
    amazonAffiliateUrl = null,
  )
}
