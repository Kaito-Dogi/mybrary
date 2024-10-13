package app.kaito_dogi.mybrary.core.repository

import app.kaito_dogi.mybrary.core.data.command.PostBookCommand
import app.kaito_dogi.mybrary.core.data.command.PostMyBookCommand
import app.kaito_dogi.mybrary.core.data.datasource.BookRemoteDataSource
import app.kaito_dogi.mybrary.core.data.datasource.MyBookRemoteDataSource
import app.kaito_dogi.mybrary.core.data.dto.MyBookDto
import app.kaito_dogi.mybrary.core.domain.model.Book
import app.kaito_dogi.mybrary.core.domain.model.BookId
import app.kaito_dogi.mybrary.core.domain.model.MyBook
import app.kaito_dogi.mybrary.core.domain.model.MyBookId
import app.kaito_dogi.mybrary.core.domain.repository.MyBookRepository
import app.kaito_dogi.mybrary.core.repository.convertor.toAuthorsResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class MyBookRepositoryImpl @Inject constructor(
  private val bookRemoteDataSource: BookRemoteDataSource,
  private val myBookRemoteDataSource: MyBookRemoteDataSource,
) : MyBookRepository {
  override suspend fun getMyBookList(): List<MyBook> {
    // FIXME: ここでユーザー ID を取得して getMyBooks に渡す
    val dtoList = myBookRemoteDataSource.getMyBooks(userId = "")
    return dtoList.map(MyBookDto::toMyBook)
  }

  override suspend fun getMyBook(myBookId: MyBookId): MyBook {
    val dto = myBookRemoteDataSource.getMyBook(myBookId = myBookId.value)
    return dto.toMyBook()
  }

  override suspend fun addBookToMybrary(book: Book): MyBook {
    val bookId = getBookIdOrCreate(book = book)

    // FIXME: ここでユーザー ID を取得して postMyBook に渡す
    val dto = myBookRemoteDataSource.postMyBook(
      command = PostMyBookCommand(
        bookId = bookId.value,
        userId = "",
      ),
    )
    return dto.toMyBook()
  }

  private suspend fun getBookIdOrCreate(book: Book): BookId {
    val recordedBook = bookRemoteDataSource.getBookByIsbn(isbn = book.isbn)?.toBook()

    return if (recordedBook != null) {
      book.id
    } else {
      val newBook = bookRemoteDataSource.postBook(
        command = PostBookCommand(
          title = book.title,
          imageUrl = book.imageUrl.value,
          isbn = book.isbn,
          publisher = book.publisher,
          authors = book.authorList.toAuthorsResponse(),
          genre = book.genre.value,
          rakutenUrl = book.rakutenUrl.value,
        ),
      ).toBook()
      newBook.id
    }
  }

  override suspend fun pinMyBook(myBookId: MyBookId): MyBook {
    val dto = myBookRemoteDataSource.patchMyBookIsPinned(
      myBookId = myBookId.value,
      isPinned = true,
    )
    return dto.toMyBook()
  }

  override suspend fun addMyBookToFavorites(myBookId: MyBookId): MyBook {
    val dto = myBookRemoteDataSource.patchMyBookIsFavorite(
      myBookId = myBookId.value,
      isFavorite = true,
    )
    return dto.toMyBook()
  }

  override suspend fun removeMyBookFromFavorites(myBookId: MyBookId): MyBook {
    val dto = myBookRemoteDataSource.patchMyBookIsFavorite(
      myBookId = myBookId.value,
      isFavorite = false,
    )
    return dto.toMyBook()
  }

  override suspend fun makeMyBookPublic(myBookId: MyBookId): MyBook {
    val dto = myBookRemoteDataSource.patchMyBookIsPublic(
      myBookId = myBookId.value,
      isPublic = true,
    )
    return dto.toMyBook()
  }

  override suspend fun makeMyBookPrivate(myBookId: MyBookId): MyBook {
    val dto = myBookRemoteDataSource.patchMyBookIsPublic(
      myBookId = myBookId.value,
      isPublic = false,
    )
    return dto.toMyBook()
  }

  override suspend fun archiveMyBook(myBookId: MyBookId): MyBook {
    val dto = myBookRemoteDataSource.patchMyBookIsArchived(
      myBookId = myBookId.value,
      isArchived = true,
    )
    return dto.toMyBook()
  }
}
