package app.kaito_dogi.mybrary.core.data.convertor

import app.kaito_dogi.mybrary.core.api.mybrary.response.model.TimeStampResponse
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

internal fun TimeStampResponse.toLocalDateTime() =
  LocalDateTime.parse(this, DateTimeFormatter.ISO_LOCAL_DATE_TIME)
