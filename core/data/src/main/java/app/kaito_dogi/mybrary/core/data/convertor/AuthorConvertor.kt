package app.kaito_dogi.mybrary.core.data.convertor

import app.kaito_dogi.mybrary.core.api.mybrary.response.model.AuthorResponse
import app.kaito_dogi.mybrary.core.domain.model.Author

internal fun AuthorResponse.toAuthor() = Author(name = this.name)
