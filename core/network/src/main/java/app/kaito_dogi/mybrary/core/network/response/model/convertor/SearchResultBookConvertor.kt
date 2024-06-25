package app.kaito_dogi.mybrary.core.network.response.model.convertor

import app.kaito_dogi.mybrary.core.common.model.Url
import app.kaito_dogi.mybrary.core.domain.model.ExternalBookId
import app.kaito_dogi.mybrary.core.domain.model.SearchResultAuthor
import app.kaito_dogi.mybrary.core.domain.model.SearchResultBook
import app.kaito_dogi.mybrary.core.network.response.model.ItemResponse

// TODO: pageCount の undefined 値を定数化する
fun ItemResponse.toSearchResultBook() = SearchResultBook(
  externalId = ExternalBookId(value = id),
  title = volumeInfo?.title ?: "",
  imageUrl = Url.Image(value = volumeInfo?.imageLinks?.thumbnail ?: ""),
  isbn10 = volumeInfo?.industryIdentifiers?.firstOrNull { it.type == app.kaito_dogi.mybrary.core.network.response.model.IndustryIdentifierType.Isbn10 }?.identifier
    ?: "",
  isbn13 = volumeInfo?.industryIdentifiers?.firstOrNull { it.type == app.kaito_dogi.mybrary.core.network.response.model.IndustryIdentifierType.Isbn13 }?.identifier
    ?: "",
  pageCount = volumeInfo?.pageCount ?: 0,
  publisher = volumeInfo?.publisher ?: "",
  authors = volumeInfo?.authors?.map { SearchResultAuthor(name = it) } ?: emptyList(),
)
