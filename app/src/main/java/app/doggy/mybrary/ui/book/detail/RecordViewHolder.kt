package app.doggy.mybrary.ui.book.detail

import androidx.recyclerview.widget.RecyclerView
import app.doggy.mybrary.R
import app.doggy.mybrary.core.domain.model.book.BookTotalPage
import app.doggy.mybrary.databinding.ItemDiaryBinding
import app.doggy.mybrary.core.domain.model.record.Record
import java.text.SimpleDateFormat
import java.util.Locale

// FIXME: totalPage をコンストラクタで渡さなくて良い方法を考える
class RecordViewHolder(
  private val binding: ItemDiaryBinding,
  private val totalPage: BookTotalPage,
) : RecyclerView.ViewHolder(binding.root) {
  fun bind(record: Record) {
    binding.currentPageAndPercentText.text = binding.root.context.getString(
      R.string.text_current_page_and_percent_text,
      record.startPage,
      100 * record.endPage / totalPage.value,
    )
    binding.datetimeText.text = SimpleDateFormat(
      binding.root.context.getString(R.string.text_datetime_text),
      Locale.JAPAN,
    ).format(record.recordedAt.value)
    binding.contentText.text = record.memo
  }
}
