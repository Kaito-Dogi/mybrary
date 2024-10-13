package app.kaito_dogi.mybrary.core.api.rakuten.response

import kotlinx.serialization.Serializable

@Serializable
data class ItemResponse(
  val affiliateUrl: String,
  val author: AuthorResponse,
  val isbn: String,
  val publisherName: String,
  val salesDate: String,
  val size: SizeResponse,
  val smallImageUrl: String,
  val title: String,
)
