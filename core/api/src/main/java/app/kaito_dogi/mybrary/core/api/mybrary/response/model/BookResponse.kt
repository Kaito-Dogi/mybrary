package app.kaito_dogi.mybrary.core.api.mybrary.response.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookResponse(
  val id: String,
  val title: String,
  @SerialName("image_url")
  val imageUrl: String,
  val isbn: String,
  val publisher: String,
  val authors: AuthorsResponse,
  val genre: GenreResponse,
  @SerialName("rakuten_affiliate_url")
  val rakutenAffiliateUrl: String,
  @SerialName("amazon_affiliate_url")
  val amazonAffiliateUrl: String?,
)
