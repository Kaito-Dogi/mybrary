package app.doggy.mybrary.core.domain.legacy.model.book

@JvmInline
value class BookTotalPage(val value: Int) {
  init {
    require(value > 0)
  }
}
