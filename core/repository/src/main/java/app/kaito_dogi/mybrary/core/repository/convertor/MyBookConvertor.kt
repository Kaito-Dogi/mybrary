package app.kaito_dogi.mybrary.core.repository.convertor

import app.kaito_dogi.mybrary.core.common.model.Url
import app.kaito_dogi.mybrary.core.database.MyBookEntity
import app.kaito_dogi.mybrary.core.domain.model.Book
import app.kaito_dogi.mybrary.core.domain.model.Genre
import app.kaito_dogi.mybrary.core.domain.model.MyBook
import app.kaito_dogi.mybrary.core.domain.model.MyBookId

internal fun MyBookEntity.toMyBook() = MyBook(
  id = MyBookId(value = this.id),
  title = this.title,
  imageUrl = Url.Image(value = this.imageUrl),
  authorList = this.authors.toAuthorList(),
  publisher = this.publisher,
  isbn = this.isbn,
  genre = Genre.entries.firstOrNull { it.value == this.genre } ?: Genre.All,
  // rakuten_url カラム追加前に保存された MyBook は、ISBN の検索 URL にフォールバックする
  rakutenUrl = Url.Affiliate(
    value = this.rakutenUrl.ifBlank { "https://books.rakuten.co.jp/search?sitem=${this.isbn}" },
  ),
  isPinned = this.isPinned,
  isFavorite = this.isFavorite,
  isArchived = this.isArchived,
)

internal fun Book.toMyBookEntity(
  id: String,
  createdAt: Long,
) = MyBookEntity(
  id = id,
  title = this.title,
  imageUrl = this.imageUrl.value,
  authors = this.authorList.toAuthorsString(),
  publisher = this.publisher,
  isbn = this.isbn,
  genre = this.genre.value,
  rakutenUrl = this.rakutenUrl.value,
  isPinned = false,
  isFavorite = false,
  isArchived = false,
  createdAt = createdAt,
)
