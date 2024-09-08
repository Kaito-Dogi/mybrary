package app.kaito_dogi.mybrary.core.data.repository

import app.kaito_dogi.mybrary.core.api.mybrary.MybraryAnonApi
import app.kaito_dogi.mybrary.core.api.mybrary.MybraryAuthApi
import app.kaito_dogi.mybrary.core.api.mybrary.request.PatchMyBookFavoriteRequest
import app.kaito_dogi.mybrary.core.api.mybrary.request.PostBookRequest
import app.kaito_dogi.mybrary.core.api.mybrary.request.PostMyBookRequest
import app.kaito_dogi.mybrary.core.api.mybrary.response.model.MyBookResponse
import app.kaito_dogi.mybrary.core.common.coroutines.dispatcher.MybraryDispatcher
import app.kaito_dogi.mybrary.core.common.coroutines.dispatcher.MybraryDispatchers
import app.kaito_dogi.mybrary.core.data.convertor.toAuthorsResponse
import app.kaito_dogi.mybrary.core.data.convertor.toMyBook
import app.kaito_dogi.mybrary.core.domain.model.Book
import app.kaito_dogi.mybrary.core.domain.model.MyBook
import app.kaito_dogi.mybrary.core.domain.model.MyBookId
import app.kaito_dogi.mybrary.core.domain.repository.MyBookRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

@Singleton
internal class MyBookRepositoryImpl @Inject constructor(
  private val mybraryAnonApi: MybraryAnonApi,
  private val mybraryAuthApi: MybraryAuthApi,
  @MybraryDispatcher(MybraryDispatchers.Io) private val dispatcher: CoroutineDispatcher,
) : MyBookRepository {
  override suspend fun getMyBookList(): List<MyBook> = withContext(dispatcher) {
    mybraryAnonApi.getMyBooks().map(MyBookResponse::toMyBook)
  }

  override suspend fun getMyBook(myBookId: MyBookId): MyBook = withContext(dispatcher) {
    TODO("Not yet implemented")
  }

  override suspend fun addBookToMybrary(book: Book): MyBook = withContext(dispatcher) {
    val bookId = mybraryAnonApi.getBookByIsbn(
      isbn = book.isbn,
    )?.id ?: mybraryAuthApi.postBook(
      request = PostBookRequest(
        title = book.title,
        imageUrl = book.imageUrl.value,
        isbn = book.isbn,
        publisher = book.publisher,
        authors = book.authorList.toAuthorsResponse(),
        genre = book.genre.value,
      ),
    ).id

    val response = mybraryAuthApi.postMyBook(
      request = PostMyBookRequest(
        bookId = bookId,
      ),
    )

    return@withContext response.toMyBook()
  }

  override suspend fun pinMyBook(myBookId: MyBookId): MyBook = withContext(dispatcher) {
    TODO("Not yet implemented")
  }

  override suspend fun addMyBookToFavorites(myBookId: MyBookId): MyBook = withContext(dispatcher) {
    val response = mybraryAuthApi.patchMyBookFavorite(
      id = myBookId.value,
      request = PatchMyBookFavoriteRequest(isFavorite = true),
    )
    return@withContext response.toMyBook()
  }

  override suspend fun removeMyBookFromFavorites(myBookId: MyBookId): MyBook =
    withContext(dispatcher) {
      val response = mybraryAuthApi.patchMyBookFavorite(
        id = myBookId.value,
        request = PatchMyBookFavoriteRequest(isFavorite = false),
      )
      return@withContext response.toMyBook()
    }

  override suspend fun makeMyBookPublic(myBookId: MyBookId): MyBook = withContext(dispatcher) {
    TODO("Not yet implemented")
  }

  override suspend fun makeMyBookPrivate(myBookId: MyBookId): MyBook = withContext(dispatcher) {
    TODO("Not yet implemented")
  }

  override suspend fun archiveMyBook(myBookId: MyBookId): MyBook = withContext(dispatcher) {
    TODO("Not yet implemented")
  }
}
