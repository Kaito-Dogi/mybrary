package app.kaito_dogi.mybrary.core.common.model

import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class CaptchaToken(
  val value: String,
)
