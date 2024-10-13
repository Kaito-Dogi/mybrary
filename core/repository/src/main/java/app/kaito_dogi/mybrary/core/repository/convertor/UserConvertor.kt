package app.kaito_dogi.mybrary.core.repository.convertor

import app.kaito_dogi.mybrary.core.api.mybrary.response.model.UserResponse
import app.kaito_dogi.mybrary.core.domain.model.User
import app.kaito_dogi.mybrary.core.domain.model.UserId

internal fun UserResponse.toUser() = User(
  id = UserId(value = this.id),
  name = this.name,
)
