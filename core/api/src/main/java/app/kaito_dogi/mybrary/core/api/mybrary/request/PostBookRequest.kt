package app.kaito_dogi.mybrary.core.api.mybrary.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PostBookRequest(
  val title: String,
  @SerialName("image_url")
  val imageUrl: String,
  val isbn: String,
  val publisher: String,
  val authors: String,
  val genre: Int,
  @SerialName("rakuten_affiliate_url")
  val rakutenAffiliateUrl: String,
)
