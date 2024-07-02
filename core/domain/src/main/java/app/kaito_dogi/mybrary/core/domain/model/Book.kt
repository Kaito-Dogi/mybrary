package app.kaito_dogi.mybrary.core.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Book(
  val id: BookId,
  val externalId: ExternalBookId,
  val title: String,
  val imageUrl: Url.Image? = null,
  val isbn10: String? = null,
  val isbn13: String? = null,
  val pageCount: Int? = null,
  val publisher: String? = null,
  val authors: List<Author>,
)
