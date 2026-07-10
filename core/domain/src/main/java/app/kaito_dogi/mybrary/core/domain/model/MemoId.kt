package app.kaito_dogi.mybrary.core.domain.model

import kotlinx.serialization.Serializable

/**
 * [Memo] の ID
 *
 * @property value ID の値
 */
@Serializable
data class MemoId(
  val value: String,
)
