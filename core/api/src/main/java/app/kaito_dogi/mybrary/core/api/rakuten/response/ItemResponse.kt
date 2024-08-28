package app.kaito_dogi.mybrary.core.api.rakuten.response

import kotlinx.serialization.Serializable

@Serializable
data class ItemResponse(
  val affiliateUrl: String,
  val author: String,
  val isbn: String,
  val largeImageUrl: String,
  val mediumImageUrl: String,
  val publisherName: String,
  val salesDate: String,
  val seriesNameKana: String,
  val size: String,
  val smallImageUrl: String,
  val title: String,
)
