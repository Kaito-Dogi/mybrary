package app.kaito_dogi.mybrary.core.domain.repository

import app.kaito_dogi.mybrary.core.domain.model.BookId

interface BookRepository {
  suspend fun getBook(id: BookId)
}
