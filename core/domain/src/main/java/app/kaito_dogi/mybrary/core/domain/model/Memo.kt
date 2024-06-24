package app.kaito_dogi.mybrary.core.domain.model

import app.kaito_dogi.mybrary.core.common.serializer.LocalDateTimeSerializer
import java.time.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class Memo(
  val id: MemoId,
  val myBookId: MyBookId,
  val user: User,
  val content: String,
  val fromPage: Int? = null,
  val toPage: Int? = null,
  @Serializable(with = LocalDateTimeSerializer::class)
  val createdAt: LocalDateTime,
  @Serializable(with = LocalDateTimeSerializer::class)
  val updatedAt: LocalDateTime? = null,
  @Serializable(with = LocalDateTimeSerializer::class)
  val publishedAt: LocalDateTime? = null,
  val likeCount: Int? = null,
)
