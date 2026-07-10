package app.kaito_dogi.mybrary.core.domain.model

/**
 * 書籍検索結果のソート順
 *
 * @property value 楽天ブックス書籍検索 API の sort パラメータの値
 */
enum class Sort(val value: String) {
  /** 標準 */
  Default(value = "standard"),

  /** 売れている順 */
  Popular(value = "sales"),

  /** 発売日が新しい順 */
  Newest(value = "-releaseDate"),

  /** 発売日が古い順 */
  Oldest(value = "+releaseDate"),
}
