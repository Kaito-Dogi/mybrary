package app.kaito_dogi.mybrary.core.data.dto

import app.kaito_dogi.mybrary.core.domain.model.Author

typealias AuthorsDto = String

fun AuthorsDto.toAuthorList() = this.split("/").map { Author(name = it) }
