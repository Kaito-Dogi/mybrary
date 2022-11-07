package app.doggy.newmybrary.legacy

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import app.doggy.newmybrary.R
import app.doggy.newmybrary.databinding.ActivityRecordBinding
import coil.load
import dagger.hilt.android.AndroidEntryPoint
import io.realm.Realm
import io.realm.RealmResults
import io.realm.Sort

@AndroidEntryPoint
class RecordActivity : AppCompatActivity() {

  private lateinit var binding: ActivityRecordBinding

  private val realm: Realm by lazy {
    Realm.getDefaultInstance()
  }

  lateinit var bookId: String
  lateinit var book: BookEntity

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityRecordBinding.inflate(layoutInflater)
    setContentView(binding.root)

    supportActionBar?.hide()

    bookId = intent.getStringExtra("bookId") as String
    book = realm.where(BookEntity::class.java).equalTo("id", bookId).findFirst() as BookEntity

    if (book.imageId == "") {
      binding.bookImageInRecord.setImageResource(R.drawable.book_black)
    } else {
      binding.bookImageInRecord.load(book.imageId)
    }

    val recordList = readAll(bookId)

    val adapter =
      RecordAdapter(
        recordList,
        object : RecordAdapter.OnItemClickListener {
          override fun onItemClick(item: RecordEntity) {
            val postIntent = Intent(baseContext, RecordPostActivity::class.java)
            postIntent.putExtra("id", item.id)
            startActivity(postIntent)
          }
        },
        object : RecordAdapter.OnItemLongClickListener {
          override fun onItemLongClick(item: RecordEntity) {
            AlertDialog
              .Builder(this@RecordActivity)
              .setMessage(R.string.delete_record_dialog_message)
              .setPositiveButton(getText(R.string.delete_dialog_positive_button)) { dialog, which ->
                Toast.makeText(baseContext, getText(R.string.delete_record_toast_text), Toast.LENGTH_SHORT).show()
                deleteRecord(item.id)
                updateCurrentPage(bookId, book)
              }
              .setNegativeButton(getText(R.string.delete_dialog_negative_button)) { dialog, which ->
              }
              .show()
          }
        },
        true,
      )

    binding.recordRecyclerView.setHasFixedSize(true)
    binding.recordRecyclerView.layoutManager = LinearLayoutManager(this)
    binding.recordRecyclerView.adapter = adapter

    binding.recordPostFab.setOnClickListener {
      val postIntent = Intent(baseContext, RecordPostActivity::class.java)
      postIntent.putExtra("bookId", book.id)
      postIntent.putExtra("bookPageCount", book.pageCount)
      startActivity(postIntent)
    }

    binding.recordAppBar.setOnMenuItemClickListener { menuItem ->
      when (menuItem.itemId) {
        R.id.edit -> {
          val postIntent = Intent(baseContext, BookPostActivity::class.java)
          postIntent.putExtra("id", book.id)
          startActivity(postIntent)
          true
        }
        R.id.delete -> {
          AlertDialog
            .Builder(this@RecordActivity)
            .setMessage(R.string.delete_book_dialog_message)
            .setPositiveButton(getText(R.string.delete_dialog_positive_button)) { dialog, which ->
              Toast.makeText(
                baseContext,
                getText(R.string.delete_toast_text_before).toString() + book?.title + getText(R.string.delete_toast_text_after),
                Toast.LENGTH_SHORT,
              ).show()
              deleteAll(bookId, book as BookEntity)
              finish()
            }
            .setNegativeButton(getText(R.string.delete_dialog_negative_button)) { dialog, which ->
            }
            .show()
          true
        }
        else -> false
      }
    }
  }

  override fun onResume() {
    super.onResume()
    binding.titleText.text = book.title
    binding.authorText.text = book.author
    binding.pageCountText.text = "${book.pageCount}" + getText(R.string.total_page_text)
    binding.descriptionText.text = book.description
    updateCurrentPage(bookId, book)
  }

  override fun onDestroy() {
    super.onDestroy()
    realm.close()
  }

  private fun readAll(bookId: String): RealmResults<RecordEntity> {
    return realm.where(RecordEntity::class.java)
      .equalTo("bookId", bookId)
      .findAll()
      .sort("createdAt", Sort.DESCENDING)
  }

  private fun deleteRecord(id: String) {
    realm.executeTransaction {
      val record = realm.where(RecordEntity::class.java).equalTo("id", id).findFirst()
        ?: return@executeTransaction
      record.deleteFromRealm()
    }
  }

  private fun deleteAll(bookId: String, book: BookEntity) {
    realm.executeTransaction {
      val records = realm.where(RecordEntity::class.java).equalTo("bookId", bookId).findAll()
        ?: return@executeTransaction
      records.deleteAllFromRealm()
      book.deleteFromRealm()
    }
  }

  private fun updateCurrentPage(bookId: String, bookEntity: BookEntity) {
    realm.executeTransaction {
      val recordEntity = realm
        .where(RecordEntity::class.java)
        .equalTo("bookId", bookId)
        .sort("createdAt", Sort.DESCENDING)
        .findFirst()
        ?: return@executeTransaction
      bookEntity.currentPage = recordEntity.currentPage
    }
  }
}
