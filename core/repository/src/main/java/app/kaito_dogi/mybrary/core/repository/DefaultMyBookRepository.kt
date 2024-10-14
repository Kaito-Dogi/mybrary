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

internal class DefaultMyBookRepository @Inject constructor(
  private val bookRemoteDataSource: BookRemoteDataSource,
  private val myBookRemoteDataSource: MyBookRemoteDataSource,
) : MyBookRepository {
  override suspend fun getMyBookList(): List<MyBook> {
    // FIXME: ここでユーザー ID を取得して getMyBooks に渡す
    val myBookDtoList = myBookRemoteDataSource.getMyBooks(userId = "")
    return myBookDtoList.map(MyBookDto::toMyBook)
  }

  override suspend fun getMyBook(myBookId: MyBookId): MyBook {
    val myBookDto = myBookRemoteDataSource.getMyBook(myBookId = myBookId.value)
    return myBookDto.toMyBook()
  }

  override suspend fun addBookToMybrary(book: Book): MyBook {
    val bookId = getBookIdOrCreate(book = book)

    // FIXME: ここでユーザー ID を取得して postMyBook に渡す
    val myBookDto = myBookRemoteDataSource.postMyBook(
      postMyBookCommand = PostMyBookCommand(
        bookId = bookId.value,
        userId = "",
      ),
    )
    return myBookDto.toMyBook()
  }

  private suspend fun getBookIdOrCreate(book: Book): BookId {
    val recordedBook = bookRemoteDataSource.getBookByIsbn(isbn = book.isbn)?.toBook()

    return if (recordedBook != null) {
      book.id
    } else {
      val newBook = bookRemoteDataSource.postBook(
        postBookCommand = PostBookCommand(
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
    val myBookDto = myBookRemoteDataSource.patchMyBookIsPinned(
      myBookId = myBookId.value,
      isPinned = true,
    )
    return myBookDto.toMyBook()
  }

  override suspend fun addMyBookToFavorites(myBookId: MyBookId): MyBook {
    val myBookDto = myBookRemoteDataSource.patchMyBookIsFavorite(
      myBookId = myBookId.value,
      isFavorite = true,
    )
    return myBookDto.toMyBook()
  }

  override suspend fun removeMyBookFromFavorites(myBookId: MyBookId): MyBook {
    val myBookDto = myBookRemoteDataSource.patchMyBookIsFavorite(
      myBookId = myBookId.value,
      isFavorite = false,
    )
    return myBookDto.toMyBook()
  }

  override suspend fun makeMyBookPublic(myBookId: MyBookId): MyBook {
    val myBookDto = myBookRemoteDataSource.patchMyBookIsPublic(
      myBookId = myBookId.value,
      isPublic = true,
    )
    return myBookDto.toMyBook()
  }

  override suspend fun makeMyBookPrivate(myBookId: MyBookId): MyBook {
    val myBookDto = myBookRemoteDataSource.patchMyBookIsPublic(
      myBookId = myBookId.value,
      isPublic = false,
    )
    return myBookDto.toMyBook()
  }

  override suspend fun archiveMyBook(myBookId: MyBookId): MyBook {
    val myBookDto = myBookRemoteDataSource.patchMyBookIsArchived(
      myBookId = myBookId.value,
      isArchived = true,
    )
    return myBookDto.toMyBook()
  }
}
