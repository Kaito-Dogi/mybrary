package app.kaito_dogi.mybrary.core.supabase.response

import app.kaito_dogi.mybrary.core.data.dto.AuthorsDto
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
internal value class AuthorsResponse(val value: String) {
  fun toAuthorsDto() = AuthorsDto(value = this.value)
}
