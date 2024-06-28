package app.kaito_dogi.mybrary.core.api.mybrary.response.model

import kotlinx.serialization.Serializable

@Serializable
data class MyBookResponse(
  val id: Long,
  val title: String,
)
