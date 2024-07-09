package app.kaito_dogi.mybrary.core.data.repository

import app.kaito_dogi.mybrary.core.api.mybrary.MybraryAuthApi
import app.kaito_dogi.mybrary.core.api.mybrary.response.model.MyBookResponse
import app.kaito_dogi.mybrary.core.common.coroutines.dispatcher.Dispatcher
import app.kaito_dogi.mybrary.core.common.coroutines.dispatcher.MybraryDispatchers
import app.kaito_dogi.mybrary.core.data.convertor.toMyBook
import app.kaito_dogi.mybrary.core.domain.model.MyBook
import app.kaito_dogi.mybrary.core.domain.model.MyBookId
import app.kaito_dogi.mybrary.core.domain.model.SearchResultBook
import app.kaito_dogi.mybrary.core.domain.repository.MyBookRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

@Singleton
internal class MyBookRepositoryImpl @Inject constructor(
  private val mybraryAuthApi: MybraryAuthApi,
  @Dispatcher(MybraryDispatchers.IO) private val dispatcher: CoroutineDispatcher,
) : MyBookRepository {
  override suspend fun getMyBookList(): List<MyBook> = withContext(dispatcher) {
    mybraryAuthApi.getMyBooks().map(MyBookResponse::toMyBook)
  }

  override suspend fun getMyBook(myBookId: MyBookId): MyBook {
    TODO("Not yet implemented")
  }

  override suspend fun registerMyBook(searchResultBook: SearchResultBook): Boolean {
    TODO("Not yet implemented")
  }

  override suspend fun pinMyBook(myBookId: MyBookId): MyBook {
    TODO("Not yet implemented")
  }

  override suspend fun addMyBookToFavorites(myBookId: MyBookId): MyBook {
    TODO("Not yet implemented")
  }

  override suspend fun removeMyBookFromFavorites(myBookId: MyBookId): MyBook {
    TODO("Not yet implemented")
  }

  override suspend fun makeMyBookPublic(myBookId: MyBookId): MyBook {
    TODO("Not yet implemented")
  }

  override suspend fun makeMyBookPrivate(myBookId: MyBookId): MyBook {
    TODO("Not yet implemented")
  }

  override suspend fun archiveMyBook(myBookId: MyBookId): MyBook {
    TODO("Not yet implemented")
  }
}
