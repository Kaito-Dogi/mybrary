package app.kaito_dogi.mybrary.core.repository.mock.convertor

import app.kaito_dogi.mybrary.core.domain.model.Author

internal fun String.toAuthorList() = this.split("/").map { Author(name = it) }
