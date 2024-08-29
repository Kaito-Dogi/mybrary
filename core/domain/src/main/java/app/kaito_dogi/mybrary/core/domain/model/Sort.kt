package app.kaito_dogi.mybrary.core.domain.model

enum class Sort(val value: String) {
  Default(value = "standard"),
  Popular(value = "sales"),
  Newest(value = "-releaseDate"),
  Oldest(value = "+releaseDate"),
  ;
}
