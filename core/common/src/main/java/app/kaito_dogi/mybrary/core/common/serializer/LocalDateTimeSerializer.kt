package app.kaito_dogi.mybrary.core.common.serializer

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

object LocalDateTimeSerializer : KSerializer<LocalDateTime> {
  override val descriptor: SerialDescriptor =
    PrimitiveSerialDescriptor("LocalDateTime", PrimitiveKind.STRING)

  override fun deserialize(decoder: Decoder): LocalDateTime {
    return LocalDateTime.parse(decoder.decodeString(), DateTimeFormatter.ISO_LOCAL_DATE_TIME)
  }

  override fun serialize(
    encoder: Encoder,
    value: LocalDateTime,
  ) {
    encoder.encodeString(value.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME))
  }
}
