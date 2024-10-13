package app.kaito_dogi.mybrary.core.supabase.memo

import app.kaito_dogi.mybrary.core.data.command.PostMemoCommand

internal fun PostMemoCommand.toInput() = MemoInput(
  myBookId = this.myBookId,
  content = this.content,
  startPage = this.startPage,
  endPage = this.endPage,
)
