package app.kaito_dogi.mybrary.core.network.model

import kotlinx.serialization.Serializable

@Serializable
data class VolumeInfo(
  val title: String,
  val authors: List<String>,
  val publisher: String,
  val publishedDate: String,
  val description: String,
  val industryIdentifiers: List<IndustryIdentifier>,
  val pageCount: Int,
  val imageLinks: ImageLinks,
)
