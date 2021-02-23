package app.doggy.newmybrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.api.load
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_record.*

class RecordActivity : AppCompatActivity() {

    private val realm: Realm by lazy {
        Realm.getDefaultInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_record)

        val bookId = intent.getStringExtra("bookId")
        val book = realm.where(Book::class.java).equalTo("bookId", bookId).findFirst()
        bookImageInRecord.load(book?.imageId)
        titleText.text = book?.title
        authorText.text = book?.author
        pageCountText.text = "p${book?.pageCount.toString()}"
        descriptionText.text = book?.description
    }

}