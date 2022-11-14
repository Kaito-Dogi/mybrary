package app.doggy.newmybrary.ui.book.register

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import app.doggy.newmybrary.R
import app.doggy.newmybrary.databinding.FragmentRegisterBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RegisterFragment : Fragment(R.layout.fragment_register) {
  companion object {
    fun newInstance() = RegisterFragment()
  }

  private var _binding: FragmentRegisterBinding? = null
  private val binding: FragmentRegisterBinding
    get() = _binding!!

  private val viewModel: RegisterViewModel by viewModels()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    _binding = FragmentRegisterBinding.bind(view)
    setUpButton()
    collectUiState()
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }

  private fun setUpButton() {
    binding.registerButton.setOnClickListener {
      viewModel.onRegisterButtonClick(
        // TODO: booksApiId, imageUrl が存在する場合を考える
        title = binding.titleEditText.text.toString(),
        author = binding.authorEditText.text.toString(),
        description = binding.descriptionEditText.text.toString(),
        totalPage = binding.totalPageEditText.text.toString(),
      )
    }
  }

  private fun collectUiState() {
    lifecycleScope.launch {
      repeatOnLifecycle(Lifecycle.State.STARTED) {
        viewModel.uiState.collect { uiState ->
          if (uiState.isBookRegistered) {
            findNavController().popBackStack()
          }
          uiState.errorMessageRes?.let { errorMessageRes ->
            Snackbar.make(binding.coordinator, errorMessageRes, Snackbar.LENGTH_SHORT).show()
            viewModel.onErrorMessageShown()
          }
          binding.registerButton.text = if (uiState.isLoading) "" else requireContext().getString(R.string.text_register_button)
          binding.progressIndicator.isVisible = uiState.isLoading
        }
      }
    }
  }
}
