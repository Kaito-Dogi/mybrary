package app.kaito_dogi.mybrary.core.api.rakuten.response

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable(with = SizeResponseSerializer::class)
enum class SizeResponse(val value: String) {
  All(value = "全て"),
  Hardcover(value = "単行本"),
  Paperback(value = "文庫"),
  NewBook(value = "新書"),
  CompleteWorks(value = "全集・双書"),
  Dictionary(value = "事・辞典"),
  IllustratedBook(value = "図鑑"),
  PictureBook(value = "絵本"),
  CassetteCd(value = "カセット、ＣＤ等"),
  Comics(value = "コミック"),
  MookOthers(value = "ムックその他"),
  ;
}

private object SizeResponseSerializer : KSerializer<SizeResponse> {
  override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor(
    serialName = SizeResponse::class.java.name,
    kind = PrimitiveKind.STRING,
  )

  override fun deserialize(decoder: Decoder): SizeResponse {
    return when (decoder.decodeString()) {
      "単行本" -> SizeResponse.Hardcover
      "文庫" -> SizeResponse.Paperback
      "新書" -> SizeResponse.NewBook
      "全集・双書" -> SizeResponse.CompleteWorks
      "事・辞典" -> SizeResponse.Dictionary
      "図鑑" -> SizeResponse.IllustratedBook
      "絵本" -> SizeResponse.PictureBook
      "カセット、ＣＤ等" -> SizeResponse.CassetteCd
      "コミック" -> SizeResponse.Comics
      "ムックその他" -> SizeResponse.MookOthers
      else -> SizeResponse.All
    }
  }

  override fun serialize(
    encoder: Encoder,
    value: SizeResponse,
  ) {
    encoder.encodeString(value.value)
  }
}
