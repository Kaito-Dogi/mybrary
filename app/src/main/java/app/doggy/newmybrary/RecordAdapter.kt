package app.doggy.newmybrary

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.realm.OrderedRealmCollection
import io.realm.RealmRecyclerViewAdapter
import kotlinx.android.synthetic.main.item_record_data_cell.view.*

class RecordAdapter(
    private val context: Context,
    private var recordList: OrderedRealmCollection<Record>?,
    private var listener: OnItemClickListener,
    private val autoUpdate: Boolean
): RealmRecyclerViewAdapter<Record, RecordAdapter.RecordViewHolder>(recordList, autoUpdate) {

    override fun getItemCount(): Int = recordList?.size ?: 0

    override fun onBindViewHolder(holder: RecordViewHolder, position: Int) {
        val record: Record = recordList?.get(position) ?: return

        holder.recordContainer.setOnClickListener{
            listener.onItemClick(record)
        }

        holder.currentPageText.setText(R.string.current_page_text)
        val currentPageText = holder.currentPageText.text.toString() + record.currentPage
        holder.currentPageText.text = currentPageText

        val percent: Int = record.currentPage * 100 / record.bookPageCount
        holder.percentText.setText(R.string.percent_text_before)
        val percentText = holder.percentText.text.toString() + percent + "%"
        holder.percentText.text = percentText

        holder.comment1Text.text = "・${record.comment1}"
        holder.comment2Text.text = "・${record.comment2}"
        holder.comment3Text.text = "・${record.comment3}"

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecordViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.item_record_data_cell, viewGroup, false)
        return RecordViewHolder(v)
    }

    class RecordViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val recordContainer : LinearLayout = view.recordContainer
        val percentText: TextView = view.percentTextInRecord
        val currentPageText: TextView = view.correntPageText
        val comment1Text: TextView = view.comment1Text
        val comment2Text: TextView = view.comment2Text
        val comment3Text: TextView = view.comment3Text
    }

    interface OnItemClickListener {
        fun onItemClick(item: Record)
    }

}