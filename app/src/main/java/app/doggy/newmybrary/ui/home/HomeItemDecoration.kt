package app.doggy.newmybrary.ui.home

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.annotation.DimenRes
import androidx.recyclerview.widget.RecyclerView
import app.doggy.newmybrary.R

class HomeItemDecoration(
  @DimenRes bookMarginRes: Int,
  context: Context,
) : RecyclerView.ItemDecoration() {
  private val bookMargin = context.resources.getDimension(bookMarginRes).toInt()

  override fun getItemOffsets(
    outRect: Rect,
    view: View,
    parent: RecyclerView,
    state: RecyclerView.State,
  ) {
    super.getItemOffsets(outRect, view, parent, state)
    val childPosition = parent.getChildAdapterPosition(view)

    when (parent.adapter?.getItemViewType(childPosition)) {
      R.layout.item_book -> outRect.set(
        bookMargin,
        bookMargin,
        bookMargin,
        bookMargin,
      )
      else -> {
        // Do nothing.
      }
    }
  }
}
