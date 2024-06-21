package app.kaito_dogi.mybrary.core.domain.repository

import app.kaito_dogi.mybrary.core.domain.model.MyBook
import app.kaito_dogi.mybrary.core.domain.model.MyBookId

interface MyBookRepository {
  suspend fun getMyBooks(): List<MyBook>

  suspend fun getMyBook(myBookId: MyBookId): MyBook

  suspend fun registerMyBook(externalBookId: String): Boolean

  suspend fun pinMyBook(myBookId: MyBookId): MyBook

  suspend fun addMyBookToFavorites(myBookId: MyBookId): MyBook

  suspend fun removeMyBookFromFavorites(myBookId: MyBookId): MyBook

  suspend fun archiveMyBook(myBookId: MyBookId): MyBook
}
