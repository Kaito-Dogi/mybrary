package app.kaito_dogi.mybrary.core.domain.model

import kotlinx.serialization.Serializable

/**
 * [Book] の ID
 *
 * @property value ID の値
 */
@Serializable
data class BookId(
  val value: String,
)
