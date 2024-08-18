package app.kaito_dogi.mybrary.core.supabase.rpc

import kotlinx.serialization.Serializable

internal sealed interface RpcParameters {
  @Serializable
  data class ToggleMyBookIsFavorite(
    val id: Long,
  ) : RpcParameters
}
