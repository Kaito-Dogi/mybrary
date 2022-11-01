package app.doggy.newmybrary

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import app.doggy.newmybrary.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import io.realm.Realm
import io.realm.RealmResults
import io.realm.Sort

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding

  private val realm: Realm by lazy {
    Realm.getDefaultInstance()
  }

  lateinit var bookList: RealmResults<Book>

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    bookList = readAll()

    val adapter = BookAdapter(
      bookList,
      object : BookAdapter.OnItemClickListener {
        override fun onItemClick(item: Book) {
          val recordIntent = Intent(baseContext, RecordActivity::class.java)
          recordIntent.putExtra("bookId", item.id)
          startActivity(recordIntent)
        }
      },
      true,
    )

    binding.bookRecyclerView.setHasFixedSize(true)
    binding.bookRecyclerView.layoutManager = GridLayoutManager(baseContext, 3)
    binding.bookRecyclerView.adapter = adapter

    binding.readFab.setOnClickListener {
      val readIntent = Intent(baseContext, ReadActivity::class.java)
      startActivity(readIntent)
    }

    binding.bookPostFab.setOnClickListener {
      val postIntent = Intent(baseContext, BookPostActivity::class.java)
      startActivity(postIntent)
    }
  }

  override fun onResume() {
    super.onResume()
    binding.emptyText.isVisible = bookList.isEmpty()
  }

  override fun onDestroy() {
    super.onDestroy()
    realm.close()
  }

  private fun readAll(): RealmResults<Book> {
    return realm.where(Book::class.java).findAll().sort("createdAt", Sort.DESCENDING)
  }
}
