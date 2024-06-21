package app.kaito_dogi.mybrary.core.data

import app.kaito_dogi.mybrary.core.domain.model.MyBook
import app.kaito_dogi.mybrary.core.domain.model.MyBookId
import app.kaito_dogi.mybrary.core.domain.repository.MyBookRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class MyBookRepositoryImpl @Inject constructor() : MyBookRepository {
  override suspend fun getMyBooks(): List<MyBook> {
    TODO("Not yet implemented")
  }

  override suspend fun getMyBook(myBookId: MyBookId): MyBook {
    TODO("Not yet implemented")
  }

  override suspend fun registerBook(externalBookId: String): Boolean {
    TODO("Not yet implemented")
  }

  override suspend fun pinBook(myBookId: MyBookId): MyBook {
    TODO("Not yet implemented")
  }

  override suspend fun makeBookFavorite(myBookId: MyBookId): MyBook {
    TODO("Not yet implemented")
  }

  override suspend fun removeMyBookFromFavorites(myBookId: MyBookId): MyBook {
    TODO("Not yet implemented")
  }

  override suspend fun archiveBook(myBookId: MyBookId): MyBook {
    TODO("Not yet implemented")
  }
}
