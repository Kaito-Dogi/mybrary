package app.doggy.newmybrary.ui.book.detail

import androidx.recyclerview.widget.RecyclerView
import app.doggy.newmybrary.R
import app.doggy.newmybrary.databinding.ItemDiaryBinding
import app.doggy.newmybrary.domain.model.Diary
import java.text.SimpleDateFormat
import java.util.Locale

class DiaryViewHolder(
  private val binding: ItemDiaryBinding,
  private val totalPage: Int,
) : RecyclerView.ViewHolder(binding.root) {
  fun bind(diary: Diary) {
    binding.currentPageAndPercentText.text = binding.root.context.getString(
      R.string.text_current_page_and_percent_text,
      diary.currentPage,
      diary.getPercent(totalPage),
    )
    binding.datetimeText.text = SimpleDateFormat(
      binding.root.context.getString(R.string.text_datetime_text),
      Locale.JAPAN,
    ).format(diary.recordedAt)
    binding.contentText.text = diary.content
  }
}
