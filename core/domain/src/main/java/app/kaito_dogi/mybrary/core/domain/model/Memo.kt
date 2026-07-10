package app.kaito_dogi.mybrary.core.domain.model

import app.kaito_dogi.mybrary.core.domain.serializer.LocalDateTimeSerializer
import java.time.LocalDateTime
import kotlinx.serialization.Serializable

/**
 * 読書メモ
 *
 * @property id メモの ID
 * @property content メモの内容
 * @property pageRange メモ対象のページ範囲
 * @property createdAt 作成日時
 * @property editedAt 編集日時（未編集の場合は null）
 */
@Serializable
data class Memo(
  val id: MemoId,
  val content: String,
  val pageRange: PageRange? = null,
  @Serializable(with = LocalDateTimeSerializer::class)
  val createdAt: LocalDateTime,
  @Serializable(with = LocalDateTimeSerializer::class)
  val editedAt: LocalDateTime? = null,
)
