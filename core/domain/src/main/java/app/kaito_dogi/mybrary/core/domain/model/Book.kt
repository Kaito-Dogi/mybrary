package app.kaito_dogi.mybrary.core.domain.model

import app.kaito_dogi.mybrary.core.common.model.Url
import kotlinx.serialization.Serializable

@Serializable
data class Book(
  val id: BookId,
  val externalId: ExternalBookId,
  val title: String,
  val imageUrl: Url.Image,
  val isbn10: String,
  val isbn13: String,
  val pageCount: Int,
  val authors: List<Author>,
)
