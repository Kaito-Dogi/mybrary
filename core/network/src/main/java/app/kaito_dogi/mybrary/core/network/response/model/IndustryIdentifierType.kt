package app.kaito_dogi.mybrary.core.network.response.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class IndustryIdentifierType {
  @SerialName("ISBN_10")
  Isbn10,

  @SerialName("ISBN_13")
  Isbn13,

  @SerialName("OTHER")
  Other,
}
