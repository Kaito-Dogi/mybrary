package app.doggy.mybrary.ui.book.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.doggy.mybrary.R
import app.doggy.mybrary.databinding.FragmentDetailBinding
import app.doggy.mybrary.core.domain.model.legacy.LegacyBook
import coil.load
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {
  private var _binding: FragmentDetailBinding? = null
  private val binding: FragmentDetailBinding
    get() = _binding!!

  private val viewModel: DetailViewModel by viewModels()

  private val args: DetailFragmentArgs by navArgs()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    _binding = FragmentDetailBinding.bind(view)
    setUpToolbar()
    setUpButton()
    collectUiState()
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }

  private fun setUpToolbar() {
    binding.toolBar.setNavigationOnClickListener {
      findNavController().popBackStack()
    }

    // TODO: オプションメニューをクリックしたときの処理
    binding.toolBar.setOnMenuItemClickListener { menuItem ->
      when (menuItem.itemId) {
        R.id.pin -> true
        R.id.edit -> true
        R.id.info -> true
        else -> false
      }
    }
  }

  private fun setUpButton() {
    binding.recordButton.setOnClickListener {
      val action = DetailFragmentDirections.actionDetailToRecord(args.bookId)
      findNavController().navigate(action)
    }
  }

  private fun setUpRecycler(legacyBook: LegacyBook) {
    // FIXME: totalPage をコンストラクタで渡さなくてはならないので、 Book の情報を取得するのを待つ必要があり、 onViewCreated で Adapter のインスタンスを生成・保持できない
    val adapter = DiaryAdapter(legacyBook.totalPage)
    binding.recycler.setHasFixedSize(true)
    binding.recycler.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
    binding.recycler.adapter = adapter
    adapter.submitList(legacyBook.diaries)
  }

  private fun collectUiState() {
    lifecycleScope.launch {
      repeatOnLifecycle(Lifecycle.State.STARTED) {
        viewModel.uiState.collect { uiState ->
          binding.toolBar.title = uiState.legacyBook.title
          val imageUrl = uiState.legacyBook.imageUrl
          // FIXME: 画像の URL が空のときにダミーの画像を表示しなくても良いかも
          if (imageUrl.isNullOrBlank()) binding.bookImage.setImageResource(R.drawable.icon_book)
          else binding.bookImage.load(uiState.legacyBook.imageUrl)
          setUpRecycler(uiState.legacyBook)

          uiState.errorMessageRes?.let { errorMessageRes ->
            Snackbar.make(binding.root, errorMessageRes, Snackbar.LENGTH_SHORT).show()
            viewModel.onErrorMessageShown()
          }
        }
      }
    }
  }
}
