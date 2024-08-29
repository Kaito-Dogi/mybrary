package app.kaito_dogi.mybrary.core.supabase.table

internal enum class Table(
  val value: String,
  val columnsAll: String,
) {
  Book(
    value = "book",
    columnsAll = "+",
  ),
  Memo(
    value = "memo",
    columnsAll = "*,my_book(profile:user_id(*))",
  ),
  MyBook(
    value = "my_book",
    columnsAll = "*,profile:user_id(*),book:book_id(*,author(*))",
  ),
}
