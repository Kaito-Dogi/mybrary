package app.kaito_dogi.mybrary.core.data.convertor

import app.kaito_dogi.mybrary.core.domain.model.Genre

// FIXME: enum で変換できるようにする
fun Int.toGenre() = when (this) {
  0 -> Genre.All
  1 -> Genre.Hardcover
  2 -> Genre.Paperback
  3 -> Genre.NewBook
  4 -> Genre.CompleteWorks
  5 -> Genre.Dictionary
  6 -> Genre.IllustratedBook
  7 -> Genre.Paperback
  8 -> Genre.CassetteCd
  9 -> Genre.Comics
  10 -> Genre.MookOthers
  else -> throw IllegalArgumentException("Invalid Genre")
}
