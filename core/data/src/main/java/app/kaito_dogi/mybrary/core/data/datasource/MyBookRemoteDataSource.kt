package app.kaito_dogi.mybrary.core.data.datasource

import app.kaito_dogi.mybrary.core.data.dto.MyBookDto

interface MyBookRemoteDataSource {
  suspend fun getMyBook(myBookId: String): MyBookDto

  suspend fun getMyBooks(
    userId: String,
  ): List<MyBookDto>

  suspend fun postMyBook(
    userId: String,
    bookId: String,
  ): MyBookDto

  suspend fun patchMyBookIsPinned(
    myBookId: String,
    isPinned: Boolean,
  ): MyBookDto

  suspend fun patchMyBookIsFavorite(
    myBookId: String,
    isFavorite: Boolean,
  ): MyBookDto

  suspend fun patchMyBookIsPublic(
    myBookId: String,
    isPublic: Boolean,
  ): MyBookDto

  suspend fun patchMyBookIsArchived(
    myBookId: String,
    isArchived: Boolean,
  ): MyBookDto

  suspend fun deleteMyBook(myBookId: String)
}
