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
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import app.doggy.newmybrary.R
import app.doggy.newmybrary.databinding.FragmentHomeBinding
import app.doggy.newmybrary.legacy.ReadActivity
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

// FIXME: spanCount を変更できるようにしたい
private const val SPAN_COUNT = 3

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
    binding.recycler.setHasFixedSize(true)
    binding.recycler.layoutManager =
      GridLayoutManager(requireActivity(), SPAN_COUNT).apply {
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
    binding.registerButton.setOnClickListener {
      findNavController().navigate(R.id.action_home_to_register)
    }
  }

  private fun collectUiState(adapter: HomeAdapter) {
    lifecycleScope.launch {
      repeatOnLifecycle(Lifecycle.State.STARTED) {
        viewModel.uiState.collect { uiState ->
          uiState.clickedBookId?.let {
            // TODO: 詳細画面に遷移
            val action = HomeFragmentDirections.actionHomeToDetail(it)
            findNavController().navigate(action)
            viewModel.onNavigate()
          }
          uiState.errorMessageRes?.let { errorMessageRes ->
            Snackbar.make(binding.coordinator, errorMessageRes, Snackbar.LENGTH_SHORT).show()
            viewModel.onErrorMessageShown()
          }
          // FIXME: 読み込み時はスケルトンスクリーンにする
          binding.progressIndicator.isVisible = uiState.isLoading && uiState.uiModels.isEmpty()
          binding.emptyText.isVisible = !uiState.isLoading && uiState.uiModels.isEmpty()
          adapter.update(uiState.uiModels)
        }
      }
    }
  }
}
