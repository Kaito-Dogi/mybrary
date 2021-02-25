package app.doggy.newmybrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_record_post.*
import java.util.*

class RecordPostActivity : AppCompatActivity() {

    private val realm: Realm by lazy {
        Realm.getDefaultInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_record_post)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val bookId = intent.getStringExtra("bookId")
        val bookPageCount = intent.getIntExtra("bookPageCount", 1)
        val id = intent.getStringExtra("id")

        if (id != null) {

            recordAddButton.setText(R.string.book_update_button)

            val record = realm.where(Record::class.java).equalTo("id", id).findFirst()
            currentPageEditText.setText(record?.currentPage.toString())
            comment1EditText.setText(record?.comment1)
            comment2EditText.setText(record?.comment2)
            comment3EditText.setText(record?.comment3)
        }

        recordAddButton.setOnClickListener {
            if (currentPageEditText.text.toString() != "" && currentPageEditText.text.toString().toInt() > 0) {
                if (bookId != null) {
                    create(
                            bookId,
                            bookPageCount,
                            currentPageEditText.text.toString().toInt(),
                            comment1EditText.text.toString(),
                            comment2EditText.text.toString(),
                            comment3EditText.text.toString()
                    )

                    updateCurrentPage(bookId, currentPageEditText.text.toString().toInt())

                } else if (id != null) {
                    update(
                            id,
                            currentPageEditText.text.toString().toInt(),
                            comment1EditText.text.toString(),
                            comment2EditText.text.toString(),
                            comment3EditText.text.toString()
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
        comment3: String
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
            comment3: String
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

    private fun updateCurrentPage(bookId: String, currentPage: Int) {
        realm.executeTransaction {
            val book = realm.where(Book::class.java).equalTo("id", bookId).findFirst()
                    ?: return@executeTransaction
            book.currentPage = currentPage
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}