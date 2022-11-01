package app.doggy.newmybrary

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.doggy.newmybrary.databinding.ItemRecordDataCellBinding
import io.realm.OrderedRealmCollection
import io.realm.RealmRecyclerViewAdapter

class RecordAdapter(
  private var recordList: OrderedRealmCollection<RecordEntity>?,
  private var listener: OnItemClickListener,
  private var longListener: OnItemLongClickListener,
  autoUpdate: Boolean,
) : RealmRecyclerViewAdapter<RecordEntity, RecordAdapter.RecordViewHolder>(recordList, autoUpdate) {

  override fun getItemCount(): Int = recordList?.size ?: 0

  override fun onBindViewHolder(holder: RecordViewHolder, position: Int) {
    val record: RecordEntity = recordList?.get(position) ?: return

    holder.binding.recordContainer.setOnClickListener {
      listener.onItemClick(record)
    }

    holder.binding.recordContainer.setOnLongClickListener {
      longListener.onItemLongClick(record)
      true
    }

    holder.binding.correntPageText.setText(R.string.current_page_text)
    val currentPageText = holder.binding.correntPageText.text.toString() + record.currentPage
    holder.binding.correntPageText.text = currentPageText

    val percent: Int = record.currentPage * 100 / record.bookPageCount
    holder.binding.percentTextInRecord.setText(R.string.percent_text_before)
    val percentText = holder.binding.percentTextInRecord.text.toString() + percent + "%"
    holder.binding.percentTextInRecord.text = percentText

    holder.binding.comment1Text.text = "・${record.comment1}"
    holder.binding.comment2Text.text = "・${record.comment2}"
    holder.binding.comment3Text.text = "・${record.comment3}"
  }

  override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecordViewHolder {
    val binding = ItemRecordDataCellBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
    return RecordViewHolder(binding)
  }

  class RecordViewHolder(val binding: ItemRecordDataCellBinding) : RecyclerView.ViewHolder(binding.root)

  interface OnItemClickListener {
    fun onItemClick(item: RecordEntity)
  }

  interface OnItemLongClickListener {
    fun onItemLongClick(item: RecordEntity)
  }
}
