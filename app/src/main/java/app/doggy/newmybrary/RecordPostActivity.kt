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

        val bookTitle = intent.getStringExtra("bookTitle")

        addRecordButton.setOnClickListener {
            create(
                bookTitle as String,
                comment3EditText.text.toString()
            )
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }

    fun create(bookTitle: String, content: String) {
        realm.executeTransaction {
            val record = it.createObject(Record::class.java, UUID.randomUUID().toString())
            record.bookTitle = bookTitle
            record.comment1 = content
        }
    }
}