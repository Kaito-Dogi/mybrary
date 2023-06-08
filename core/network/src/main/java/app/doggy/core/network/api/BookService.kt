package app.doggy.core.network.api

import app.doggy.core.network.book.BookService
import javax.inject.Inject
import retrofit2.create

// FIXME: service の配り方を考える
class BookApi @Inject constructor(
  retrofitManager: RetrofitManager,
) {
  val service = retrofitManager.retrofit.create<BookService>()
}
