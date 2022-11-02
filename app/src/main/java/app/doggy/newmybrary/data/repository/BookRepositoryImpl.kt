package app.doggy.newmybrary.data.repository

import app.doggy.newmybrary.data.api.service.BookApi
import app.doggy.newmybrary.domain.model.Book
import app.doggy.newmybrary.domain.model.toBook
import app.doggy.newmybrary.domain.repository.BookRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

// FIXME: Hilt モジュールの置き場所を考える
@InstallIn(SingletonComponent::class)
@Module
internal interface BookRepositoryModule {
  @Binds
  fun BookRepositoryImpl.bindBookRepository(): BookRepository
}

class BookRepositoryImpl @Inject constructor(
  private val bookApi: BookApi,
) : BookRepository {
  override suspend fun fetchBooksByIsbn(isbn: String): List<Book> = withContext(Dispatchers.IO) {
    bookApi.service.fetchBookByIsbn(isbn).body()?.items?.map { it.toBook() } ?: listOf()
  }
}
