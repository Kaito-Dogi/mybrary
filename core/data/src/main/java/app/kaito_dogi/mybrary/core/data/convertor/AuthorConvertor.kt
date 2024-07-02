package app.kaito_dogi.mybrary.core.data.convertor

import app.kaito_dogi.mybrary.core.api.mybrary.response.model.AuthorResponse
import app.kaito_dogi.mybrary.core.domain.model.Author
import app.kaito_dogi.mybrary.core.domain.model.AuthorId

internal fun AuthorResponse.toAuthor() = Author(
  id = AuthorId(value = this.id),
  name = this.name,
)
