package app.kaito_dogi.mybrary.core.repository.convertor

import app.kaito_dogi.mybrary.core.api.rakuten.response.AuthorResponse
import app.kaito_dogi.mybrary.core.domain.model.Author

internal fun List<Author>.toAuthorsResponse() = this.joinToString(separator = "/") { it.name }

fun AuthorResponse.toAuthorList() = this.split("/").map { Author(name = it) }
