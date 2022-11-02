package app.doggy.newmybrary.data.repository.impl

import app.doggy.newmybrary.data.api.service.BookApi
import app.doggy.newmybrary.data.repository.`interface`.BookRepository
import app.doggy.newmybrary.domain.model.Book
import app.doggy.newmybrary.domain.model.toBook
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(
  private val bookApi: BookApi,
) : BookRepository {
  override suspend fun fetchBooksByIsbn(isbn: String): List<Book> =
    bookApi.service.fetchBookByIsbn(isbn).body()?.items?.map { it.toBook() } ?: listOf()
}
