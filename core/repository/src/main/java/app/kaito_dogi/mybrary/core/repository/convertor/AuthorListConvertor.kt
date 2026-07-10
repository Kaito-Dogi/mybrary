package app.kaito_dogi.mybrary.core.repository.convertor

import app.kaito_dogi.mybrary.core.domain.model.Author

internal fun List<Author>.toAuthorsString() = this.joinToString(separator = "/") { it.name }

internal fun String.toAuthorList() = this.split("/").map { Author(name = it) }
