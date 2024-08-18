package app.kaito_dogi.mybrary.core.supabase.model

import kotlinx.serialization.Serializable

internal sealed interface RpcParameters {
  @Serializable
  data class ToggleMyBookIsFavoriteParameters(
    val id: Long,
  ) : RpcParameters
}
