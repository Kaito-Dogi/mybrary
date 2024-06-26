package app.kaito_dogi.mybrary.core.domain.repository

import app.kaito_dogi.mybrary.core.domain.model.MyBook
import app.kaito_dogi.mybrary.core.domain.model.MyBookId
import app.kaito_dogi.mybrary.core.domain.model.SearchResultBook

interface MyBookRepository {
  suspend fun getMyBookList(): List<MyBook>

  suspend fun getMyBook(myBookId: MyBookId): MyBook

  suspend fun registerMyBook(searchResultBook: SearchResultBook): Boolean

  suspend fun pinMyBook(myBookId: MyBookId): MyBook

  suspend fun addMyBookToFavorites(myBookId: MyBookId): MyBook

  suspend fun removeMyBookFromFavorites(myBookId: MyBookId): MyBook

  suspend fun makeMyBookPublic(myBookId: MyBookId): MyBook

  suspend fun makeMyBookPrivate(myBookId: MyBookId): MyBook

  suspend fun archiveMyBook(myBookId: MyBookId): MyBook
}
