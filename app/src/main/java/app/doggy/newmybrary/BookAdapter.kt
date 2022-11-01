package app.doggy.newmybrary

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.doggy.newmybrary.databinding.ItemBookDataCellBinding
import coil.load
import io.realm.OrderedRealmCollection
import io.realm.RealmRecyclerViewAdapter

class BookAdapter(
  private var bookList: OrderedRealmCollection<BookEntity>?,
  private var listener: OnItemClickListener,
  autoUpdate: Boolean,
) : RealmRecyclerViewAdapter<BookEntity, BookAdapter.BookViewHolder>(bookList, autoUpdate) {

  override fun getItemCount(): Int = bookList?.size ?: 0

  override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
    val book: BookEntity = bookList?.get(position) ?: return

    holder.binding.bookContainer.setOnClickListener {
      listener.onItemClick(book)
    }

    if (book.imageId == "") {
      holder.binding.bookImageInCell.setImageResource(R.drawable.book_black)
    } else {
      holder.binding.bookImageInCell.load(book.imageId)
    }

    val percent: Int = book.currentPage * 100 / book.pageCount
    holder.binding.percentTextInBook.text = "$percent%"
  }

  override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): BookViewHolder {
    val binding = ItemBookDataCellBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
    return BookViewHolder(binding)
  }

  class BookViewHolder(val binding: ItemBookDataCellBinding) : RecyclerView.ViewHolder(binding.root)

  interface OnItemClickListener {
    fun onItemClick(item: BookEntity)
  }
}
