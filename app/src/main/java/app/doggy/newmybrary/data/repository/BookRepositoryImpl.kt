package app.doggy.newmybrary.data.repository

import app.doggy.newmybrary.data.api.service.BookApi
import app.doggy.newmybrary.data.db.MybraryDatabase
import app.doggy.newmybrary.data.db.entity.BookAuthorCrossRef
import app.doggy.newmybrary.data.db.entity.toAuthorEntityList
import app.doggy.newmybrary.data.db.entity.toBookEntity
import app.doggy.newmybrary.domain.model.Book
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
  // fun BookRepositoryImpl.bindBookRepository(): BookRepository
  @Binds
  fun FakeBookRepository.bindBookRepository(): BookRepository
}

class BookRepositoryImpl @Inject constructor(
  private val bookApi: BookApi,
  private val db: MybraryDatabase,
) : BookRepository {
  override suspend fun fetchBooksByIsbn(isbn: String): List<Book> = withContext(Dispatchers.IO) {
    bookApi.service.fetchBookByIsbn(isbn).body()?.items?.map { it.toBook() } ?: listOf()
  }

  override suspend fun getBooks(): List<Book> = withContext(Dispatchers.IO) {
    db.bookDao().getBooks().map { it.toBook() }
  }

  override suspend fun registerBook(book: Book): Boolean = withContext(Dispatchers.IO) {
    val bookId = db.bookDao().insert(book.toBookEntity())
    book.toAuthorEntityList().forEach { author ->
      val authorId = db.authorDao().insert(author)
      db.bookAuthorCrossRefDao().insert(
        BookAuthorCrossRef(
          bookId = bookId,
          authorId = authorId,
        ),
      )
    }
    true
  }
}
