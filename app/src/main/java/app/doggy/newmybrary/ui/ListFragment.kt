package app.doggy.newmybrary.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import app.doggy.newmybrary.*
import app.doggy.newmybrary.databinding.FragmentListBinding
import io.realm.Realm
import io.realm.RealmResults
import io.realm.Sort
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : Fragment() {

    private val realm: Realm by lazy {
        Realm.getDefaultInstance()
    }

    private lateinit var bookList: RealmResults<Book>

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bookList = readAll()

        val adapter =
            BookAdapter(requireContext(), bookList, object : BookAdapter.OnItemClickListener {
                override fun onItemClick(item: Book) {
                    val recordIntent = Intent(requireContext(), RecordActivity::class.java)
                    recordIntent.putExtra("bookId", item.id)
                    startActivity(recordIntent)
                }
            }, true)

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        binding.recyclerView.adapter = adapter

        binding.readQrFab.setOnClickListener {
            val readIntent = Intent(requireContext(), ReadActivity::class.java)
            startActivity(readIntent)
        }

        binding.postBookFab.setOnClickListener {
            val postIntent = Intent(requireContext(), BookPostActivity::class.java)
            startActivity(postIntent)
        }
    }

    override fun onResume() {
        super.onResume()
        binding.emptyView.isVisible = bookList.isEmpty()
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }

    private fun readAll(): RealmResults<Book> {
        return realm.where(Book::class.java).findAll().sort("createdAt", Sort.DESCENDING)
    }
}
