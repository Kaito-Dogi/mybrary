package app.kaito_dogi.mybrary.core.supabase.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class Book(
  val id: String,
  val title: String,
  val authors: String,
  val publisher: String,
  @SerialName("image_url")
  val imageUrl: String,
  val isbn: String,
  @SerialName("is_archived")
  val genre: Int,
  @SerialName("rakuten_affiliate_url")
  val rakutenAffiliateUrl: String,
  @SerialName("amazon_affiliate_url")
  val amazonAffiliateUrl: String? = null,
)
