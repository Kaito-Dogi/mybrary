package app.kaito_dogi.mybrary.core.supabase.table

internal enum class Table(
  val value: String,
  val columnsAll: String,
) {
  Book(
    value = "book",
    columnsAll = "*",
  ),
  Memo(
    value = "memo",
    columnsAll = "*",
  ),
  MyBook(
    value = "my_book",
    columnsAll = "*,book:book_id(*)",
  ),
}
