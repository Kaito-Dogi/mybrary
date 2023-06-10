package app.doggy.mybrary.ui.book.detail

import androidx.recyclerview.widget.RecyclerView
import app.doggy.mybrary.R
import app.doggy.mybrary.databinding.ItemDiaryBinding
import app.doggy.mybrary.core.domain.model.legacy.LegacyDiary
import java.text.SimpleDateFormat
import java.util.Locale

// FIXME: totalPage をコンストラクタで渡さなくて良い方法を考える
class DiaryViewHolder(
  private val binding: ItemDiaryBinding,
  private val totalPage: Int,
) : RecyclerView.ViewHolder(binding.root) {
  fun bind(legacyDiary: LegacyDiary) {
    binding.currentPageAndPercentText.text = binding.root.context.getString(
      R.string.text_current_page_and_percent_text,
      legacyDiary.currentPage,
      legacyDiary.getPercent(totalPage),
    )
    binding.datetimeText.text = SimpleDateFormat(
      binding.root.context.getString(R.string.text_datetime_text),
      Locale.JAPAN,
    ).format(legacyDiary.recordedAt)
    binding.contentText.text = legacyDiary.content
  }
}
