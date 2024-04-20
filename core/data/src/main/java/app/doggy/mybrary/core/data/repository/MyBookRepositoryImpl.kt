package app.doggy.mybrary.core.data.repository

import app.doggy.mybrary.core.domain.model.MyBook
import app.doggy.mybrary.core.domain.model.MyBookId
import app.doggy.mybrary.core.domain.repository.MyBookRepository
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
      externalId = "MyBook",
      title = "MyBook",
      author = "MyBook",
      imageUrl = "MyBook",
      isPinned = false,
      isFavorite = false,
      isArchived = false,
      memos = emptyList(),
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
      externalId = "MyBook",
      title = "MyBook",
      author = "MyBook",
      imageUrl = "MyBook",
      isPinned = false,
      isFavorite = false,
      isArchived = false,
      memos = emptyList(),
    )
  }

  // TODO: 実装
  override suspend fun makeBookFavorite(
    myBookId: MyBookId,
  ): MyBook {
    return MyBook(
      id = MyBookId(0L),
      externalId = "MyBook",
      title = "MyBook",
      author = "MyBook",
      imageUrl = "MyBook",
      isPinned = false,
      isFavorite = false,
      isArchived = false,
      memos = emptyList(),
    )
  }

  // TODO: 実装
  override suspend fun archiveBook(
    myBookId: MyBookId,
  ): MyBook {
    return MyBook(
      id = MyBookId(0L),
      externalId = "MyBook",
      title = "MyBook",
      author = "MyBook",
      imageUrl = "MyBook",
      isPinned = false,
      isFavorite = false,
      isArchived = false,
      memos = emptyList(),
    )
  }
}
