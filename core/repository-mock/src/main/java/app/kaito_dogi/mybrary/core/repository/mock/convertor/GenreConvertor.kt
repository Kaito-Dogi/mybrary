package app.kaito_dogi.mybrary.core.repository.mock.convertor

import app.kaito_dogi.mybrary.core.api.rakuten.response.SizeResponse
import app.kaito_dogi.mybrary.core.domain.model.Genre

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
