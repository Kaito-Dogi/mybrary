package app.kaito_dogi.mybrary.core.domain.model

import kotlinx.serialization.Serializable

sealed interface Url {
  val value: String

  @Serializable
  data class Image(
    override val value: String,
  ) : app.kaito_dogi.mybrary.core.domain.model.Url
}
