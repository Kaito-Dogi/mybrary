package app.doggy.newmybrary.ui.home

import android.view.View
import app.doggy.newmybrary.R
import app.doggy.newmybrary.databinding.ItemBookBinding
import com.xwray.groupie.viewbinding.BindableItem

data class BookItem(
  private val uiModel: HomeUiModel.BookUiModel,
) : BindableItem<ItemBookBinding>(uiModel.hashCode().toLong()) {
  override fun bind(binding: ItemBookBinding, position: Int) {
    // TODO: 本の画像をセットする処理
    binding.percentText.text = binding.root.context.getString(R.string.percent_text, uiModel.book.getPercent())
    binding.root.setOnClickListener {
      // TODO: 詳細画面に遷移する処理
    }
  }

  override fun getLayout(): Int = R.layout.item_book

  override fun initializeViewBinding(view: View): ItemBookBinding = ItemBookBinding.bind(view)

  override fun getSpanSize(spanCount: Int, position: Int): Int = 1
}
