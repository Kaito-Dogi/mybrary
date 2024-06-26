package app.kaito_dogi.mybrary.core.data

import app.kaito_dogi.mybrary.core.domain.model.MyBook
import app.kaito_dogi.mybrary.core.domain.model.MyBookId
import app.kaito_dogi.mybrary.core.domain.model.SearchResultBook
import app.kaito_dogi.mybrary.core.domain.repository.MyBookRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class MyBookRepositoryImpl @Inject constructor() : MyBookRepository {
  override suspend fun getMyBookList(): List<MyBook> {
    TODO("Not yet implemented")
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
