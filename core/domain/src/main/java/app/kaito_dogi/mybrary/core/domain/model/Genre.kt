package app.kaito_dogi.mybrary.core.domain.model

enum class Genre(val value: Int) {
  // 全て
  All(value = 0),

  // 単行本
  Hardcover(value = 1),

  // 文庫
  Paperback(value = 2),

  // 新書
  NewBook(value = 3),

  // 全集・双書
  CompleteWorks(value = 4),

  // 事・辞典
  Dictionary(value = 5),

  // 図鑑
  IllustratedBook(value = 6),

  // 絵本
  PictureBook(value = 7),

  // カセット、CD など
  CassetteCd(value = 8),

  // コミック
  Comics(value = 9),

  // ムック、その他
  MookOthers(value = 10),
}
