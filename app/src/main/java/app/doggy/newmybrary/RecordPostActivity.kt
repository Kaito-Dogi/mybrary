package app.doggy.newmybrary

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import app.doggy.newmybrary.databinding.ActivityRecordPostBinding
import io.realm.Realm
import java.util.UUID

class RecordPostActivity : AppCompatActivity() {

  private lateinit var binding: ActivityRecordPostBinding

  private val realm: Realm by lazy {
    Realm.getDefaultInstance()
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityRecordPostBinding.inflate(layoutInflater)
    setContentView(binding.root)

    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.setDisplayShowTitleEnabled(false)

    val bookId = intent.getStringExtra("bookId")
    val bookPageCount = intent.getIntExtra("bookPageCount", 1)
    val id = intent.getStringExtra("id")

    if (id != null) {
      binding.recordAddButton.setText(R.string.book_update_button)

      val record = realm.where(Record::class.java).equalTo("id", id).findFirst()
      binding.currentPageEditText.setText(record?.currentPage.toString())
      binding.comment1EditText.setText(record?.comment1)
      binding.comment2EditText.setText(record?.comment2)
      binding.comment3EditText.setText(record?.comment3)
    }

    binding.recordAddButton.setOnClickListener {
      if (binding.currentPageEditText.text.toString() != "" && binding.currentPageEditText.text.toString().toInt() > 0) {
        if (bookId != null) {
          create(
            bookId,
            bookPageCount,
            binding.currentPageEditText.text.toString().toInt(),
            binding.comment1EditText.text.toString(),
            binding.comment2EditText.text.toString(),
            binding.comment3EditText.text.toString(),
          )
        } else if (id != null) {
          update(
            id,
            binding.currentPageEditText.text.toString().toInt(),
            binding.comment1EditText.text.toString(),
            binding.comment2EditText.text.toString(),
            binding.comment3EditText.text.toString(),
          )
        }
        finish()
      } else {
        Toast.makeText(baseContext, getText(R.string.post_toast_text), Toast.LENGTH_SHORT).show()
      }
    }
  }

  override fun onDestroy() {
    super.onDestroy()
    realm.close()
  }

  private fun create(
    bookId: String,
    bookPageCount: Int,
    currentPage: Int,
    comment1: String,
    comment2: String,
    comment3: String,
  ) {
    realm.executeTransaction {
      val record = it.createObject(Record::class.java, UUID.randomUUID().toString())
      record.bookId = bookId
      record.bookPageCount = bookPageCount
      record.currentPage = currentPage
      record.comment1 = comment1
      record.comment2 = comment2
      record.comment3 = comment3
    }
  }

  private fun update(
    id: String,
    currentPage: Int,
    comment1: String,
    comment2: String,
    comment3: String,
  ) {
    realm.executeTransaction {
      val record = realm.where(Record::class.java).equalTo("id", id).findFirst()
        ?: return@executeTransaction
      record.currentPage = currentPage
      record.comment1 = comment1
      record.comment2 = comment2
      record.comment3 = comment3
    }
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    if (item.itemId == android.R.id.home) {
      finish()
    }
    return super.onOptionsItemSelected(item)
  }
}
