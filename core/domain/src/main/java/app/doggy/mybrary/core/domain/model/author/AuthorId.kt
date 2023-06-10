package app.doggy.mybrary.core.domain.model.author

@JvmInline
value class AuthorId(val value: Long) {
  init {
    require(value > 0L || value == -1L)
  }
}
