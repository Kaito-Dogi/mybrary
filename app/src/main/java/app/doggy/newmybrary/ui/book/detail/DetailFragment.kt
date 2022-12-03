package app.doggy.newmybrary.ui.book.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import app.doggy.newmybrary.R
import app.doggy.newmybrary.databinding.FragmentDetailBinding
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
    collectUiState()
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }

  private fun collectUiState() {
    lifecycleScope.launch {
      repeatOnLifecycle(Lifecycle.State.STARTED) {
        viewModel.uiState.collect { uiState ->
          uiState.errorMessageRes?.let { errorMessageRes ->
            Snackbar.make(binding.root, errorMessageRes, Snackbar.LENGTH_SHORT).show()
            viewModel.onErrorMessageShown()
          }
        }
      }
    }
  }
}
