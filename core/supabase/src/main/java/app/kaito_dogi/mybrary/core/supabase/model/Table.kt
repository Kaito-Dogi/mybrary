package app.kaito_dogi.mybrary.core.supabase.model

internal enum class Table(
  val value: String,
  val columnsAll: String,
) {
  MyBook(
    value = "my_book",
    columnsAll = "*,profile:user_id(*),book:book_id(*,author(*))",
  ),
  Memo(
    value = "memo",
    columnsAll = "*,my_book(profile:user_id(*))",
  ),
}
