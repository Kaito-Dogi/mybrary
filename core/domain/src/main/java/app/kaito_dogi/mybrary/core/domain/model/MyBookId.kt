package app.kaito_dogi.mybrary.core.domain.model

import kotlinx.serialization.Serializable

/**
 * [MyBook] の ID
 *
 * @property value ID の値
 */
@Serializable
data class MyBookId(
  val value: String,
)
