package app.kaito_dogi.mybrary.core.domain.model

enum class Genre(val value: Int) {
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
}
