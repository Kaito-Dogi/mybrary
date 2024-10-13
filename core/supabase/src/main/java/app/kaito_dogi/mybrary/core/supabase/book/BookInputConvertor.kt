package app.kaito_dogi.mybrary.core.supabase.book

import app.kaito_dogi.mybrary.core.data.command.PostBookCommand

internal fun PostBookCommand.toBookInput() = BookInput(
  title = this.title,
  imageUrl = this.imageUrl,
  authors = this.authors,
  publisher = this.publisher,
  isbn = this.isbn,
  genre = this.genre,
  rakutenUrl = this.rakutenUrl,
)
