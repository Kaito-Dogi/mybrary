package app.doggy.mybrary.core.domain.legacy.model.book

@JvmInline
value class BookId(val value: Long = 0) {
  init {
    require(value > 0L || value == -1L)
  }
}
