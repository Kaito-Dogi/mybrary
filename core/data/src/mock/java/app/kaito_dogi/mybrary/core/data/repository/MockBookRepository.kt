package app.kaito_dogi.mybrary.core.data.repository

import app.kaito_dogi.mybrary.core.domain.model.BookId
import app.kaito_dogi.mybrary.core.domain.repository.BookRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class MockBookRepository @Inject constructor() : BookRepository {
  override suspend fun getBook(id: BookId) {
    TODO("Not yet implemented")
  }
}
