package app.kaito_dogi.mybrary.core.api.rakuten.response

import kotlinx.serialization.SerialName

enum class SizeResponse {
  @SerialName("全て")
  All,

  @SerialName("単行本")
  Hardcover,

  @SerialName("文庫")
  Paperback,

  @SerialName("新書")
  NewBook,

  @SerialName("全集・双書")
  CompleteWorks,

  @SerialName("事・辞典")
  Dictionary,

  @SerialName("図鑑")
  IllustratedBook,

  @SerialName("絵本")
  PictureBook,

  @SerialName("カセット、ＣＤ等")
  CassetteCd,

  @SerialName("コミック")
  Comics,

  @SerialName("ムックその他")
  MookOthers
}
