package app.kaito_dogi.mybrary.core.domain.model

import app.kaito_dogi.mybrary.core.common.model.Url

data class Book(
  val id: String,
  val title: String,
  val authors: String,
  val imageUrl: Url.Image,
)
