package app.kaito_dogi.mybrary.core.supabase.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class Profile(
  @SerialName("user_id")
  val userId: String,
  val name: String,
)
