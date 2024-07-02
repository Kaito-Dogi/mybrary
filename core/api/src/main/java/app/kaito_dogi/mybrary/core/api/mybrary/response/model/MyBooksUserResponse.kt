package app.kaito_dogi.mybrary.core.api.mybrary.response.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MyBooksUserResponse(
  @SerialName("users") val user: UserResponse,
)
