package app.kaito_dogi.mybrary.core.data.convertor

import app.kaito_dogi.mybrary.core.api.googlebooks.response.model.IndustryIdentifierType
import app.kaito_dogi.mybrary.core.api.googlebooks.response.model.ItemResponse
import app.kaito_dogi.mybrary.core.common.model.Url
import app.kaito_dogi.mybrary.core.domain.model.Author
import app.kaito_dogi.mybrary.core.domain.model.AuthorId
import app.kaito_dogi.mybrary.core.domain.model.Book
import app.kaito_dogi.mybrary.core.domain.model.BookId
import app.kaito_dogi.mybrary.core.domain.model.ExternalBookId

internal fun ItemResponse.toBook() = Book(
  id = BookId(value = 0),
  externalId = ExternalBookId(value = id),
  title = volumeInfo.title,
  imageUrl = volumeInfo.imageLinks?.thumbnail?.let {
    Url.Image(
      value = it.replace(
        oldValue = "http://",
        newValue = "https://",
      ),
    )
  },
  isbn10 = volumeInfo.industryIdentifiers?.firstOrNull { it.type == IndustryIdentifierType.Isbn10 }?.identifier,
  isbn13 = volumeInfo.industryIdentifiers?.firstOrNull { it.type == IndustryIdentifierType.Isbn13 }?.identifier,
  pageCount = volumeInfo.pageCount,
  publisher = volumeInfo.publisher,
  authors = volumeInfo.authors?.map {
    Author(id = AuthorId(value = 0L), name = it)
  } ?: emptyList(),
)
