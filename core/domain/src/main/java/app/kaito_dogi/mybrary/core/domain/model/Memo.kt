package app.kaito_dogi.mybrary.core.domain.model

import app.kaito_dogi.mybrary.core.common.serializer.LocalDateTimeSerializer
import java.time.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class Memo(
  val id: MemoId,
  val myBookId: MyBookId,
  val content: String,
  val fromPage: Int?,
  val toPage: Int?,
  @Serializable(with = LocalDateTimeSerializer::class)
  val createdAt: LocalDateTime,
  @Serializable(with = LocalDateTimeSerializer::class)
  val editedAt: LocalDateTime?,
  @Serializable(with = LocalDateTimeSerializer::class)
  val postedAt: LocalDateTime?,
  val likeCount: Int?,
)
