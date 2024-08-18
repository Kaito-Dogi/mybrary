package app.kaito_dogi.mybrary.core.supabase.rpc

import app.kaito_dogi.mybrary.core.supabase.table.Table

internal enum class Rpc(
  val value: String,
  val table: Table,
) {
  ToggleMyBookIsFavorite(
    value = "toggle_my_book_is_favorite",
    table = Table.MyBook,
  ),
  ToggleMyBookIsPinned(
    value = "toggle_my_book_is_pinned",
    table = Table.MyBook,
  ),
  ToggleMyBookIsPublic(
    value = "toggle_my_book_is_public",
    table = Table.MyBook,
  ),
  ToggleMyBookIsArchived(
    value = "toggle_my_book_is_archived",
    table = Table.MyBook,
  ),
  ;
}
