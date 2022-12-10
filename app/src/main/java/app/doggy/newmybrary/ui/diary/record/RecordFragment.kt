package app.doggy.newmybrary.ui.diary.record

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import app.doggy.newmybrary.R
import app.doggy.newmybrary.databinding.FragmentRecordBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecordFragment : Fragment(R.layout.fragment_record) {
  private var _binding: FragmentRecordBinding? = null
  private val binding: FragmentRecordBinding
    get() = _binding!!

  private val viewModel: RecordViewModel by viewModels()

  private val args: RecordFragmentArgs by navArgs()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    _binding = FragmentRecordBinding.bind(view)
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}
