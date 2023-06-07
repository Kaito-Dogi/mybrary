package app.doggy.mybrary.data.repository

import android.database.sqlite.SQLiteConstraintException
import app.doggy.mybrary.data.api.service.BookApi
import app.doggy.mybrary.data.db.MybraryDatabase
import app.doggy.mybrary.data.db.entity.BookAuthorCrossRef
import app.doggy.mybrary.data.db.entity.toAuthorEntities
import app.doggy.mybrary.data.db.entity.toBookEntity
import app.doggy.mybrary.data.repository.fake.FakeBookRepository
import app.doggy.mybrary.domain.model.Book
import app.doggy.mybrary.domain.repository.BookRepository
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
    bookApi.service.fetchBooksByIsbn(isbn).body()?.items?.map { it.toBook() } ?: listOf()
  }

  override suspend fun getBooks(): List<Book> = withContext(Dispatchers.IO) {
    db.bookDao().getAll().map { it.toBook() }
  }

  override suspend fun getBook(bookId: Long): Book = withContext(Dispatchers.IO) {
    db.bookDao().getBook(bookId).toBook()
  }

  override suspend fun registerBook(book: Book): Boolean = withContext(Dispatchers.IO) {
    // FIXME: BookEntity, AuthorEntity, BookAuthorCrossRef の保存処理をトランザクションにしたい
    val bookId = db.bookDao().insert(book.toBookEntity())
    book.toAuthorEntities().forEach { author ->
      val authorId = try {
        db.authorDao().insert(author)
      } catch (e: SQLiteConstraintException) {
        db.authorDao().getByName(author.name).authorId
      }
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
