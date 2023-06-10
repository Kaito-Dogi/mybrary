package app.doggy.mybrary.ui.record

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import app.doggy.mybrary.R
import app.doggy.mybrary.databinding.FragmentRecordBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RecordFragment : Fragment(R.layout.fragment_record) {
  private var _binding: FragmentRecordBinding? = null
  private val binding: FragmentRecordBinding
    get() = _binding!!

  private val viewModel: RecordViewModel by viewModels()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    _binding = FragmentRecordBinding.bind(view)
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
      viewModel.onRecordButtonClick(
        currentPage = binding.currentPageEditText.text.toString(),
        memo = binding.memoEditText.text.toString(),
      )
    }
  }

  private fun collectUiState() {
    lifecycleScope.launch {
      repeatOnLifecycle(Lifecycle.State.STARTED) {
        viewModel.uiState.collect { uiState ->
          if (uiState.isRecorded) {
            findNavController().popBackStack()
          }

          uiState.errorMessageRes?.let { errorMessageRes ->
            Snackbar.make(binding.coordinator, errorMessageRes, Snackbar.LENGTH_SHORT).show()
            viewModel.onErrorMessageShown()
          }

          binding.recordButton.text = if (uiState.isLoading) "" else requireContext().getString(R.string.text_record_button)
          binding.progressIndicator.isVisible = uiState.isLoading
        }
      }
    }
  }
}
