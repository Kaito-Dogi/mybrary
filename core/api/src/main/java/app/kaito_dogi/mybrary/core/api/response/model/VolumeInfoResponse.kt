package app.kaito_dogi.mybrary.core.api.response.model

import kotlinx.serialization.Serializable

@Serializable
data class VolumeInfoResponse(
  val title: String? = null,
  val subtitle: String? = null,
  val authors: List<String>? = null,
  val publisher: String? = null,
  val publishedDate: String? = null,
  val description: String? = null,
  val industryIdentifiers: List<IndustryIdentifierResponse>? = null,
  val pageCount: Int? = null,
  val imageLinks: ImageLinksResponse? = null,
)
