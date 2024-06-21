package app.kaito_dogi.mybrary.core.ui.datetime

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private val Formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm")
fun LocalDateTime.toFormattedString(): String = this.format(Formatter)
