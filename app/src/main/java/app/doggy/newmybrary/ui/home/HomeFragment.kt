package app.doggy.newmybrary.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import app.doggy.newmybrary.BookPostActivity
import app.doggy.newmybrary.R
import app.doggy.newmybrary.ReadActivity
import app.doggy.newmybrary.databinding.FragmentHomeBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

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
    collectUiState()
    viewModel.onViewCreated()

    // val adapter = BookAdapter(
    //   bookList,
    //   object : BookAdapter.OnItemClickListener {
    //     override fun onItemClick(item: BookEntity) {
    //       val recordIntent = Intent(requireActivity(), RecordActivity::class.java)
    //       recordIntent.putExtra("bookId", item.id)
    //       startActivity(recordIntent)
    //     }
    //   },
    //   true,
    // )

    // binding.bookRecyclerView.setHasFixedSize(true)
    // binding.bookRecyclerView.layoutManager = GridLayoutManager(requireActivity(), 3)
    // binding.bookRecyclerView.adapter = adapter

    binding.readFab.setOnClickListener {
      val readIntent = Intent(requireActivity(), ReadActivity::class.java)
      startActivity(readIntent)
    }

    binding.bookPostFab.setOnClickListener {
      val postIntent = Intent(requireActivity(), BookPostActivity::class.java)
      startActivity(postIntent)
    }
  }

  override fun onDestroy() {
    super.onDestroy()
    _binding = null
  }

  private fun collectUiState() {
    lifecycleScope.launch {
      repeatOnLifecycle(Lifecycle.State.STARTED) {
        viewModel.uiState.collect { uiState ->
          // TODO: Adapter に uiState を渡す
          // TODO: くるくるのオンオフを切り替える
        }
      }
    }
  }
}
