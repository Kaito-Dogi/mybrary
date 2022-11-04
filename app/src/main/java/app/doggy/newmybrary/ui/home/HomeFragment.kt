package app.doggy.newmybrary.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import app.doggy.newmybrary.BookPostActivity
import app.doggy.newmybrary.R
import app.doggy.newmybrary.ReadActivity
import app.doggy.newmybrary.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {
  companion object {
    fun newInstance() = HomeFragment()
  }

  private var _binding: FragmentHomeBinding? = null
  private val binding: FragmentHomeBinding
    get() = _binding!!

  private val viewModel: HomeViewModel by viewModels()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    _binding = FragmentHomeBinding.bind(view)
    val adapter = HomeAdapter()
    setUpRecycler(adapter)
    setUpButtons()
    collectUiState(adapter)

    viewModel.onViewCreated()
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }

  private fun setUpRecycler(adapter: HomeAdapter) {
    // TODO: setHasFixedSize って必要？
    binding.recycler.setHasFixedSize(true)
    // FIXME: spanCount を変更できるようにしたい
    binding.recycler.layoutManager = GridLayoutManager(requireActivity(), 3).apply {
      spanSizeLookup = adapter.spanSizeLookup
    }
    binding.recycler.adapter = adapter
  }

  private fun setUpButtons() {
    // TODO: バーコード読み取り画面への遷移
    binding.barcodeButton.setOnClickListener {
      val readIntent = Intent(requireActivity(), ReadActivity::class.java)
      startActivity(readIntent)
    }
    // TODO: 書籍登録画面への遷移
    binding.registerButton.setOnClickListener {
      val postIntent = Intent(requireActivity(), BookPostActivity::class.java)
      startActivity(postIntent)
    }
  }

  private fun collectUiState(adapter: HomeAdapter) {
    lifecycleScope.launch {
      repeatOnLifecycle(Lifecycle.State.STARTED) {
        viewModel.uiState.collect { uiState ->
          binding.progressIndicator.isVisible = uiState.isLoading
          binding.emptyText.isVisible = !uiState.isLoading && uiState.uiModelList.isEmpty()
          adapter.update(uiState.uiModelList)
        }
      }
    }
  }
}
