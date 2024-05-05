package app.kaito_dogi.mybrary.core.domain.model

import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class UnixMillis(val value: Long)
