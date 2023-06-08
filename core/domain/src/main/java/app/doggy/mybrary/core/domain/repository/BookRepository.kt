package app.doggy.mybrary.core.domain.repository

import app.doggy.mybrary.core.domain.model.legacy.Book as LegacyBook
import app.doggy.mybrary.core.domain.model.book.Book
import kotlinx.coroutines.flow.Flow

interface BookRepository {
  suspend fun searchBooksByIsbn(
    isbn: String,
    limit: Int,
    pageIndex: Int,
  ): Flow<List<Book>>

  // TODO: リファクタする
  suspend fun fetchBooksByIsbn(isbn: String): List<LegacyBook>

  suspend fun getBooks(): List<LegacyBook>

  suspend fun getBook(bookId: Long): LegacyBook

  suspend fun registerBook(book: LegacyBook): Boolean
}
