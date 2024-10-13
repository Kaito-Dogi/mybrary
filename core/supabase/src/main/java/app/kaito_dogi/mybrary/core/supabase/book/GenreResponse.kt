package app.kaito_dogi.mybrary.core.supabase.book

import app.kaito_dogi.mybrary.core.data.dto.GenreDto
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable(with = GenreResponseSerializer::class)
enum class GenreResponse(val value: Int) {
  All(value = 0),
  Hardcover(value = 1),
  Paperback(value = 2),
  NewBook(value = 3),
  CompleteWorks(value = 4),
  Dictionary(value = 5),
  IllustratedBook(value = 6),
  PictureBook(value = 7),
  CassetteCd(value = 8),
  Comics(value = 9),
  MookOthers(value = 10),
  ;

  fun toDto(): GenreDto = when (this) {
    All -> GenreDto.All
    Hardcover -> GenreDto.Hardcover
    Paperback -> GenreDto.Paperback
    NewBook -> GenreDto.NewBook
    CompleteWorks -> GenreDto.CompleteWorks
    Dictionary -> GenreDto.Dictionary
    IllustratedBook -> GenreDto.IllustratedBook
    PictureBook -> GenreDto.PictureBook
    CassetteCd -> GenreDto.CassetteCd
    Comics -> GenreDto.Comics
    MookOthers -> GenreDto.MookOthers
  }
}

private object GenreResponseSerializer : KSerializer<GenreResponse> {
  override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor(
    serialName = GenreResponse::class.java.name,
    kind = PrimitiveKind.INT,
  )

  override fun deserialize(decoder: Decoder): GenreResponse {
    return when (val value = decoder.decodeInt()) {
      0 -> GenreResponse.All
      1 -> GenreResponse.Hardcover
      2 -> GenreResponse.Paperback
      3 -> GenreResponse.NewBook
      4 -> GenreResponse.CompleteWorks
      5 -> GenreResponse.Dictionary
      6 -> GenreResponse.IllustratedBook
      7 -> GenreResponse.PictureBook
      8 -> GenreResponse.CassetteCd
      9 -> GenreResponse.Comics
      10 -> GenreResponse.MookOthers
      else -> throw SerializationException("Unknown Genre: $value")
    }
  }

  override fun serialize(
    encoder: Encoder,
    value: GenreResponse,
  ) {
    encoder.encodeInt(value.value)
  }
}
