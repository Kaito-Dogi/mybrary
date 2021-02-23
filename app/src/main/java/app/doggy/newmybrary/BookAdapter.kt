package app.doggy.newmybrary

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import io.realm.OrderedRealmCollection
import io.realm.RealmRecyclerViewAdapter
import kotlinx.android.synthetic.main.item_book_data_cell.view.*

class BookAdapter(
    private val context: Context,
    private var bookList: OrderedRealmCollection<Book>?,
    private var listener: OnItemClickListener,
    private val autoUpdate: Boolean
): RealmRecyclerViewAdapter<Book, BookAdapter.BookViewHolder>(bookList, autoUpdate) {

    override fun getItemCount(): Int = bookList?.size ?: 0

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book: Book = bookList?.get(position) ?: return

        holder.bookContainer.setOnClickListener{
            listener.onItemClick(book)
        }
        if (book.imageId == "") {
            holder.imageView.setImageResource(R.drawable.book_black)
        } else {
            holder.imageView.load(book.imageId)
        }
        holder.percentTextView.text = (book.currentPage/book.pageCount).toString()

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): BookViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.item_book_data_cell, viewGroup, false)
        return BookViewHolder(v)
    }

    class BookViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val bookContainer : ConstraintLayout = view.bookContainer
        val imageView: ImageView = view.bookImageInCell
        val percentTextView: TextView = view.percentTextInBookCell
    }

    interface OnItemClickListener {
        fun onItemClick(item: Book)
    }

}