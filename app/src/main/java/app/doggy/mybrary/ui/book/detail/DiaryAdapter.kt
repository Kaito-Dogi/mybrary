package app.doggy.mybrary.ui.book.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import app.doggy.mybrary.databinding.ItemDiaryBinding
import app.doggy.mybrary.core.domain.model.legacy.LegacyDiary

// FIXME: totalPage をコンストラクタで渡さなくて良い方法を考える
class DiaryAdapter(
  private val totalPage: Int,
) : ListAdapter<LegacyDiary, DiaryViewHolder>(DIFF_UTIL_ITEM_CALLBACK) {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiaryViewHolder {
    val binding = ItemDiaryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return DiaryViewHolder(
      binding = binding,
      totalPage = totalPage,
    )
  }

  override fun onBindViewHolder(holder: DiaryViewHolder, position: Int) {
    holder.bind(getItem(position))
  }
}

private val DIFF_UTIL_ITEM_CALLBACK = object : DiffUtil.ItemCallback<LegacyDiary>() {
  override fun areContentsTheSame(oldItem: LegacyDiary, newItem: LegacyDiary): Boolean {
    return oldItem == newItem
  }

  override fun areItemsTheSame(oldItem: LegacyDiary, newItem: LegacyDiary): Boolean {
    return oldItem.hashCode() == newItem.hashCode()
  }
}
