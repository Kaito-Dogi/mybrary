package app.doggy.mybrary.ui.book.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import app.doggy.mybrary.core.domain.model.book.BookTotalPage
import app.doggy.mybrary.core.domain.model.record.Record
import app.doggy.mybrary.databinding.ItemRecordBinding

// FIXME: totalPage をコンストラクタで渡さなくて良い方法を考える
class RecordAdapter(
  private val totalPage: BookTotalPage,
) : ListAdapter<Record, RecordViewHolder>(DIFF_UTIL_ITEM_CALLBACK) {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordViewHolder {
    val binding = ItemRecordBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return RecordViewHolder(
      binding = binding,
      totalPage = totalPage,
    )
  }

  override fun onBindViewHolder(holder: RecordViewHolder, position: Int) {
    holder.bind(getItem(position))
  }
}

private val DIFF_UTIL_ITEM_CALLBACK = object : DiffUtil.ItemCallback<Record>() {
  override fun areContentsTheSame(oldItem: Record, newItem: Record): Boolean {
    return oldItem == newItem
  }

  override fun areItemsTheSame(oldItem: Record, newItem: Record): Boolean {
    return oldItem.hashCode() == newItem.hashCode()
  }
}
