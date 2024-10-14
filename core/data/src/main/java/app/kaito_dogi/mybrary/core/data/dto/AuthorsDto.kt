package app.kaito_dogi.mybrary.core.data.dto

import app.kaito_dogi.mybrary.core.domain.model.Author

@JvmInline
value class AuthorsDto(val value: String) {
  fun toAuthorList() = this.value.split("/").map { Author(name = it) }
}
