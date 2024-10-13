package app.kaito_dogi.mybrary.core.repository.convertor

import app.kaito_dogi.mybrary.core.api.mybrary.response.model.AuthorsResponse
import app.kaito_dogi.mybrary.core.domain.model.Author

internal fun AuthorsResponse.toAuthorList() = this.split("/").map { Author(name = it) }

internal fun List<Author>.toAuthorsResponse() = this.joinToString(separator = "/") { it.name }
