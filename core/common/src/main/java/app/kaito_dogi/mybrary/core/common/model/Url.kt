package app.kaito_dogi.mybrary.core.common.model

import kotlinx.serialization.Serializable

sealed interface Url {
  val value: String

  @Serializable
  data class Image(
    override val value: String,
  ) : Url
}
