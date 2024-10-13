package app.kaito_dogi.mybrary.core.repository.mock.convertor

import app.kaito_dogi.mybrary.core.api.mybrary.response.model.GenreResponse
import app.kaito_dogi.mybrary.core.api.rakuten.response.SizeResponse
import app.kaito_dogi.mybrary.core.domain.model.Genre

internal fun GenreResponse.toGenre() = when (this) {
  GenreResponse.All -> Genre.All
  GenreResponse.Hardcover -> Genre.Hardcover
  GenreResponse.Paperback -> Genre.Paperback
  GenreResponse.NewBook -> Genre.NewBook
  GenreResponse.CompleteWorks -> Genre.CompleteWorks
  GenreResponse.Dictionary -> Genre.Dictionary
  GenreResponse.IllustratedBook -> Genre.IllustratedBook
  GenreResponse.PictureBook -> Genre.Paperback
  GenreResponse.CassetteCd -> Genre.CassetteCd
  GenreResponse.Comics -> Genre.Comics
  GenreResponse.MookOthers -> Genre.MookOthers
}

internal fun SizeResponse.toGenre() = when (this) {
  SizeResponse.All -> Genre.All
  SizeResponse.Hardcover -> Genre.Hardcover
  SizeResponse.Paperback -> Genre.Paperback
  SizeResponse.NewBook -> Genre.NewBook
  SizeResponse.CompleteWorks -> Genre.CompleteWorks
  SizeResponse.Dictionary -> Genre.Dictionary
  SizeResponse.IllustratedBook -> Genre.IllustratedBook
  SizeResponse.PictureBook -> Genre.PictureBook
  SizeResponse.CassetteCd -> Genre.CassetteCd
  SizeResponse.Comics -> Genre.Comics
  SizeResponse.MookOthers -> Genre.MookOthers
}
