package app.doggy.mybrary.core.domain.model.record

@JvmInline
value class RecordId(val value: Long) {
  init {
    require(value > 0L || value == -1L)
  }
}
