package app.kaito_dogi.mybrary.core.domain.model

import app.kaito_dogi.mybrary.core.common.model.Url
import kotlinx.serialization.Serializable

@Serializable
data class SearchResultBook(
  val externalId: ExternalBookId,
  val title: String,
  val imageUrl: Url.Image? = null,
  val isbn10: String? = null,
  val isbn13: String? = null,
  val pageCount: Int? = null,
  val publisher: String? = null,
  val authors: List<SearchResultAuthor>,
)
