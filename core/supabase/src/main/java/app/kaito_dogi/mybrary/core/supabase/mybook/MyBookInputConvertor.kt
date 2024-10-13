package app.kaito_dogi.mybrary.core.supabase.mybook

import app.kaito_dogi.mybrary.core.data.command.PostMyBookCommand

internal fun PostMyBookCommand.toInput() = MyBookInput(
  bookId = this.bookId,
  userId = this.userId,
)
