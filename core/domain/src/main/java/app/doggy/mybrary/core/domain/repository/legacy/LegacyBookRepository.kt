package app.doggy.mybrary.core.domain.repository.legacy

import app.doggy.mybrary.core.domain.model.legacy.LegacyBook

interface LegacyBookRepository {
  suspend fun fetchBooksByIsbn(isbn: String): List<LegacyBook>

  suspend fun getBooks(): List<LegacyBook>

  suspend fun getBook(bookId: Long): LegacyBook

  suspend fun registerBook(legacyBook: LegacyBook): Boolean
}
