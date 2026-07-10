package app.kaito_dogi.mybrary.core.domain.model

import kotlinx.serialization.Serializable

/**
 * 著者
 *
 * @property name 著者名
 */
@Serializable
data class Author(
  val name: String,
)
