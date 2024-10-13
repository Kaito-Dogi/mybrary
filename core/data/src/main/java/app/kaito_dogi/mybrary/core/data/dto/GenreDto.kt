package app.kaito_dogi.mybrary.core.data.dto

import app.kaito_dogi.mybrary.core.domain.model.Genre

enum class GenreDto(val value: Int) {
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

  fun toGenre(): Genre = when (this) {
    All -> Genre.All
    Hardcover -> Genre.Hardcover
    Paperback -> Genre.Paperback
    NewBook -> Genre.NewBook
    CompleteWorks -> Genre.CompleteWorks
    Dictionary -> Genre.Dictionary
    IllustratedBook -> Genre.IllustratedBook
    PictureBook -> Genre.PictureBook
    CassetteCd -> Genre.CassetteCd
    Comics -> Genre.Comics
    MookOthers -> Genre.MookOthers
  }
}
