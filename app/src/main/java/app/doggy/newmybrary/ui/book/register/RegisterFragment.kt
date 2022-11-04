package app.doggy.newmybrary.ui.book.register

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import app.doggy.newmybrary.R
import app.doggy.newmybrary.databinding.FragmentRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment(R.layout.fragment_register) {
  companion object {
    fun newInstance() = RegisterFragment()
  }

  private var _binding: FragmentRegisterBinding? = null
  private val binding: FragmentRegisterBinding
    get() = _binding!!

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    _binding = FragmentRegisterBinding.bind(view)
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}
