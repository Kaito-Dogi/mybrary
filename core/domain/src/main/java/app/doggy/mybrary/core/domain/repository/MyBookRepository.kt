package app.doggy.mybrary.core.domain.repository

import app.doggy.mybrary.core.domain.model.MyBook
import app.doggy.mybrary.core.domain.model.MyBookId

interface MyBookRepository {
  suspend fun getMyBooks(): List<MyBook>
  suspend fun getMyBook(myBookId: MyBookId): MyBook
  suspend fun registerBook(externalBookId: String): Boolean
  suspend fun pinBook(myBookId: MyBookId): MyBook
  suspend fun makeBookFavorite(myBookId: MyBookId): MyBook
  suspend fun archiveBook(myBookId: MyBookId): MyBook
}
