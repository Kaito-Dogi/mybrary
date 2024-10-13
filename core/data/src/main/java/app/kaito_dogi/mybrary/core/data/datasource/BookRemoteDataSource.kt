package app.kaito_dogi.mybrary.core.data.datasource

import app.kaito_dogi.mybrary.core.data.command.PostBookCommand
import app.kaito_dogi.mybrary.core.data.dto.BookDto

interface BookRemoteDataSource {
  suspend fun getBookByIsbn(isbn: String): BookDto?

  suspend fun postBook(postBookCommand: PostBookCommand): BookDto
}
