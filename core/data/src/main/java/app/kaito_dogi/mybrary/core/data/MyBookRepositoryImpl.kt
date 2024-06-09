package app.kaito_dogi.mybrary.core.data

import app.kaito_dogi.mybrary.core.common.model.Url
import app.kaito_dogi.mybrary.core.domain.model.MyBook
import app.kaito_dogi.mybrary.core.domain.model.MyBookId
import app.kaito_dogi.mybrary.core.domain.repository.MyBookRepository
import javax.inject.Inject

internal class MyBookRepositoryImpl @Inject constructor() : MyBookRepository {
  // TODO: 実装
  override suspend fun getMyBooks(): List<MyBook> {
    return emptyList()
  }

  // TODO: 実装
  override suspend fun getMyBook(
    myBookId: MyBookId,
  ): MyBook {
    return MyBook(
      id = MyBookId(0L),
      externalId = "externalId",
      title = "title",
      authors = "authors",
      imageUrl = Url.Image(value = "imageUrl"),
      isPinned = false,
      isFavorite = false,
      isArchived = false,
    )
  }

  // TODO: 実装
  override suspend fun registerBook(
    externalBookId: String,
  ): Boolean {
    return true
  }

  // TODO: 実装
  override suspend fun pinBook(
    myBookId: MyBookId,
  ): MyBook {
    return MyBook(
      id = MyBookId(0L),
      externalId = "externalId",
      title = "title",
      authors = "authors",
      imageUrl = Url.Image(value = "imageUrl"),
      isPinned = false,
      isFavorite = false,
      isArchived = false,
    )
  }

  // TODO: 実装
  override suspend fun makeBookFavorite(
    myBookId: MyBookId,
  ): MyBook {
    return MyBook(
      id = MyBookId(0L),
      externalId = "externalId",
      title = "title",
      authors = "authors",
      imageUrl = Url.Image(value = "imageUrl"),
      isPinned = false,
      isFavorite = false,
      isArchived = false,
    )
  }

  // TODO: 実装
  override suspend fun archiveBook(
    myBookId: MyBookId,
  ): MyBook {
    return MyBook(
      id = MyBookId(0L),
      externalId = "externalId",
      title = "title",
      authors = "authors",
      imageUrl = Url.Image(value = "imageUrl"),
      isPinned = false,
      isFavorite = false,
      isArchived = false,
    )
  }
}
