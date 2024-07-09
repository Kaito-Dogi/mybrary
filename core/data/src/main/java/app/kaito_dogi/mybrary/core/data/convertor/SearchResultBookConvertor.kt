package app.kaito_dogi.mybrary.core.data.convertor

import app.kaito_dogi.mybrary.core.api.googlebooks.response.model.IndustryIdentifierType
import app.kaito_dogi.mybrary.core.api.googlebooks.response.model.ItemResponse
import app.kaito_dogi.mybrary.core.common.model.Url
import app.kaito_dogi.mybrary.core.domain.model.ExternalBookId
import app.kaito_dogi.mybrary.core.domain.model.SearchResultAuthor
import app.kaito_dogi.mybrary.core.domain.model.SearchResultBook

internal fun ItemResponse.toSearchResultBook() = SearchResultBook(
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
  authors = volumeInfo.authors?.map { SearchResultAuthor(name = it) } ?: emptyList(),
)
