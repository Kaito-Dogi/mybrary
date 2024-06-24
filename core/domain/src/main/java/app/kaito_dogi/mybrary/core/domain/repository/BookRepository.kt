package app.kaito_dogi.mybrary.core.domain.repository

import app.kaito_dogi.mybrary.core.domain.model.Book

interface BookRepository {
  suspend fun getBook(id: Book)
}
