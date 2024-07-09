package app.kaito_dogi.mybrary.core.api.mybrary.response.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MyBookUserResponse(
  @SerialName("user") val user: UserResponse,
)
