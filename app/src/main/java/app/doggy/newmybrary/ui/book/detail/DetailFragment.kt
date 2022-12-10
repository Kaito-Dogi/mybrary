package app.doggy.newmybrary.ui.book.detail

import android.content.Intent
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
import app.doggy.newmybrary.R
import app.doggy.newmybrary.databinding.FragmentDetailBinding
import app.doggy.newmybrary.domain.model.Book
import app.doggy.newmybrary.legacy.RecordPostActivity
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
  }

  private fun setUpButton() {
    binding.recordButton.setOnClickListener {
      requireActivity().startActivity(
        Intent(requireContext(), RecordPostActivity::class.java),
      )
    }
  }

  private fun setUpRecycler(book: Book) {
    // FIXME: totalPage をコンストラクタで渡さなくてはならないので、 Book の情報を取得するのを待つ必要があり、 onViewCreated で Adapter のインスタンスを生成・保持できない
    val adapter = DiaryAdapter(book.totalPage)
    binding.recycler.adapter = adapter
    binding.recycler.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
    adapter.submitList(book.diaries)
  }

  private fun collectUiState() {
    lifecycleScope.launch {
      repeatOnLifecycle(Lifecycle.State.STARTED) {
        viewModel.uiState.collect { uiState ->
          binding.toolBar.title = uiState.book.title
          val imageUrl = uiState.book.imageUrl
          if (imageUrl.isNullOrBlank()) binding.bookImage.setImageResource(R.drawable.icon_book)
          else binding.bookImage.load(uiState.book.imageUrl)
          setUpRecycler(uiState.book)

          uiState.errorMessageRes?.let { errorMessageRes ->
            Snackbar.make(binding.root, errorMessageRes, Snackbar.LENGTH_SHORT).show()
            viewModel.onErrorMessageShown()
          }
        }
      }
    }
  }
}
