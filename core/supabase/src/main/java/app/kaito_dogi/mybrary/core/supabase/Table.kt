package app.kaito_dogi.mybrary.core.supabase

internal enum class Table(
  val value: String,
) {
  Book(value = "book"),
  Memo(value = "memo"),
  MyBook(value = "my_book"),
  Profile(value = "profile"),
}
