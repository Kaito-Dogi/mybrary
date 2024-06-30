package app.kaito_dogi.mybrary.core.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class PageRange(
  val from: Int,
  val to: Int? = null,
)
