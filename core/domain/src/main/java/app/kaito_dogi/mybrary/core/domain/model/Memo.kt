package app.kaito_dogi.mybrary.core.domain.model

import app.kaito_dogi.mybrary.core.common.serializer.LocalDateTimeSerializer
import java.time.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class Memo(
  val id: MemoId,
  val user: User,
  val myBookId: MyBookId,
  val content: String,
  val pageRange: PageRange? = null,
  @Serializable(with = LocalDateTimeSerializer::class)
  val createdAt: LocalDateTime,
  @Serializable(with = LocalDateTimeSerializer::class)
  val editedAt: LocalDateTime? = null,
  @Serializable(with = LocalDateTimeSerializer::class)
  val publishedAt: LocalDateTime? = null,
  val likeCount: Int,
)
