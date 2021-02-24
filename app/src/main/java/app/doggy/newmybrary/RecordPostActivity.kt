package app.doggy.newmybrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        val bookId = intent.getStringExtra("bookId")
        val bookPageCount = intent.getIntExtra("bookPageCount", 1)

        recordAddButton.setOnClickListener {
            create(
                bookId as String,
                bookPageCount,
                currentPageEditText.text.toString().toInt(),
                comment1EditText.text.toString(),
                comment2EditText.text.toString(),
                comment3EditText.text.toString()
            )
            updateCurrentPage(bookId, currentPageEditText.text.toString().toInt())
            finish()
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

    private fun updateCurrentPage(bookId: String, currentPage: Int) {
        realm.executeTransaction {
            val book = realm.where(Book::class.java).equalTo("id", bookId).findFirst()
                ?: return@executeTransaction
            book.currentPage = currentPage
        }
    }
}