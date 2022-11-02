package app.doggy.newmybrary.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import app.doggy.newmybrary.BookAdapter
import app.doggy.newmybrary.BookEntity
import app.doggy.newmybrary.BookPostActivity
import app.doggy.newmybrary.R
import app.doggy.newmybrary.ReadActivity
import app.doggy.newmybrary.RecordActivity
import app.doggy.newmybrary.databinding.FragmentHomeBinding
import io.realm.Realm
import io.realm.RealmResults
import io.realm.Sort

class HomeFragment : Fragment(R.layout.fragment_home) {
  companion object {
    fun newInstance() = HomeFragment()
  }

  private var _binding: FragmentHomeBinding? = null
  private val binding: FragmentHomeBinding
    get() = _binding!!

  // FIXME: Realm の依存を剥がす
  private val realm: Realm by lazy {
    Realm.getDefaultInstance()
  }

  lateinit var bookList: RealmResults<BookEntity>

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    _binding = FragmentHomeBinding.bind(view)

    bookList = readAll()

    val adapter = BookAdapter(
      bookList,
      object : BookAdapter.OnItemClickListener {
        override fun onItemClick(item: BookEntity) {
          val recordIntent = Intent(requireActivity(), RecordActivity::class.java)
          recordIntent.putExtra("bookId", item.id)
          startActivity(recordIntent)
        }
      },
      true,
    )

    binding.bookRecyclerView.setHasFixedSize(true)
    binding.bookRecyclerView.layoutManager = GridLayoutManager(requireActivity(), 3)
    binding.bookRecyclerView.adapter = adapter

    binding.readFab.setOnClickListener {
      val readIntent = Intent(requireActivity(), ReadActivity::class.java)
      startActivity(readIntent)
    }

    binding.bookPostFab.setOnClickListener {
      val postIntent = Intent(requireActivity(), BookPostActivity::class.java)
      startActivity(postIntent)
    }
  }

  override fun onResume() {
    super.onResume()
    binding.emptyText.isVisible = bookList.isEmpty()
  }

  override fun onDestroy() {
    super.onDestroy()
    _binding = null
    realm.close()
  }

  private fun readAll(): RealmResults<BookEntity> {
    return realm.where(BookEntity::class.java).findAll().sort("createdAt", Sort.DESCENDING)
  }
}
