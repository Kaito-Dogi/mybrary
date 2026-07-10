package app.kaito_dogi.mybrary.core.domain.model

import kotlinx.serialization.Serializable

/**
 * メモ対象のページ範囲
 *
 * @property start 開始ページ
 * @property end 終了ページ（単一ページの場合は null）
 */
@Serializable
data class PageRange(
  val start: Int,
  val end: Int? = null,
)
