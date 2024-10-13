package app.kaito_dogi.mybrary.core.repository.convertor

import app.kaito_dogi.mybrary.core.api.rakuten.response.ItemResponse
import app.kaito_dogi.mybrary.core.common.model.Url
import app.kaito_dogi.mybrary.core.domain.model.Book
import app.kaito_dogi.mybrary.core.domain.model.BookId

internal fun ItemResponse.toBook() = Book(
  id = BookId(value = ""),
  title = this.title,
  imageUrl = Url.Image(
    value = this.smallImageUrl.replace(
      oldValue = "64x64",
      newValue = "512x512",
    ),
  ),
  authorList = this.author.toAuthorList(),
  publisher = this.publisherName,
  isbn = this.isbn,
  genre = this.size.toGenre(),
  rakutenUrl = Url.Affiliate(value = this.affiliateUrl),
)
