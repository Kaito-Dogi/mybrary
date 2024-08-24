package app.kaito_dogi.mybrary.core.api.mybrary.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PatchMyBookFavoriteRequest(
  @SerialName("is_favorite")
  val isFavorite: Boolean,
)
