package app.kaito_dogi.mybrary.core.domain.model

import app.kaito_dogi.mybrary.core.common.model.Url
import kotlinx.serialization.Serializable

@Serializable
data class Book(
  val id: BookId,
  val title: String,
  val imageUrl: Url.Image,
  val isbn: String,
  val publisher: String,
  val authors: List<Author>,
)
