package app.doggy.mybrary.ui.home

import android.view.View
import app.doggy.mybrary.R
import app.doggy.mybrary.databinding.ItemBookBinding
import coil.load
import com.xwray.groupie.viewbinding.BindableItem

data class BookItem(
  private val uiModel: HomeUiModel.BookUiModel,
) : BindableItem<ItemBookBinding>(uiModel.hashCode().toLong()) {
  override fun bind(binding: ItemBookBinding, position: Int) {
    uiModel.legacyBook.imageUrl?.let {
      binding.bookImage.load(it)
    }
    binding.percentText.text = binding.root.context.getString(R.string.text_percent_text, uiModel.legacyBook.getPercent())
    binding.root.setOnClickListener {
      uiModel.legacyBook.id?.let {
        uiModel.onClick(it)
      }
    }
  }

  override fun getLayout(): Int = R.layout.item_book

  override fun initializeViewBinding(view: View): ItemBookBinding = ItemBookBinding.bind(view)

  override fun getSpanSize(spanCount: Int, position: Int): Int = 1
}
