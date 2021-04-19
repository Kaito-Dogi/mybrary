package app.doggy.newmybrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import coil.api.load
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_book_post.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class BookPostActivity : AppCompatActivity() {

    private val realm: Realm by lazy {
        Realm.getDefaultInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_post)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val isbn: String? = intent.getStringExtra("isbn")

        val gson: Gson =
            GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://www.googleapis.com/books/v1/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        val bookFromIsbnService: BookDataService = retrofit.create(BookDataService::class.java)

        var imageId = ""

        if (isbn != null) {
            runBlocking(Dispatchers.IO) {
                runCatching {
                    bookFromIsbnService.getBook("isbn:$isbn")
                }
            }.onSuccess {
                if (it.items != null) {
                    if (it.items[0].volumeInfo.imageLinks != null) {
                        imageId = it.items[0].volumeInfo.imageLinks.thumbnail
                    }
                    bookImageInPost.load(imageId)
                    titleEditText.setText(it.items[0].volumeInfo.title)
                    authorEditText.setText(it.items[0].volumeInfo.authors[0])
                    pageCountEditText.setText(it.items[0].volumeInfo.pageCount.toString())
                    descriptionEditText.setText(it.items[0].volumeInfo.description)
                    Toast.makeText(baseContext, getText(R.string.on_success), Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(baseContext, getText(R.string.on_failure), Toast.LENGTH_SHORT).show()
                }
            }.onFailure {
                Toast.makeText(baseContext, getText(R.string.on_failure), Toast.LENGTH_SHORT).show()
            }
        }

        val id = intent.getStringExtra("id")

        if (id != null) {

            bookAddButton.setText(R.string.book_update_button)

            val book = realm.where(Book::class.java).equalTo("id", id).findFirst()
            if (book?.imageId != "") {
                imageId = book?.imageId as String
                bookImageInPost.load(imageId)
            }
            titleEditText.setText(book.title)
            authorEditText.setText(book.author)
            pageCountEditText.setText(book.pageCount.toString())
            descriptionEditText.setText(book.description)
        }

        bookAddButton.setOnClickListener {
            if (pageCountEditText.text.toString() != ""
                    && pageCountEditText.text.toString().toInt() > 0
                    && titleEditText.text.toString() != ""
            ) { if (id == null) {
                    create(
                            imageId,
                            titleEditText.text.toString(),
                            authorEditText.text.toString(),
                            pageCountEditText.text.toString().toInt(),
                            descriptionEditText.text.toString()
                    )
                } else {
                    update(
                            id,
                            imageId,
                            titleEditText.text.toString(),
                            authorEditText.text.toString(),
                            pageCountEditText.text.toString().toInt(),
                            descriptionEditText.text.toString()
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

    private fun create(imageId: String, title: String, author: String, pageCount: Int, description: String) {
        realm.executeTransaction {
            val book = it.createObject(Book::class.java, UUID.randomUUID().toString())
            book.imageId = imageId
            book.title = title
            book.author = author
            book.pageCount = pageCount
            book.description = description
        }
    }

    private fun update(id: String, imageId: String, title: String, author: String, pageCount: Int, description: String) {
        realm.executeTransaction {
            val book = realm.where(Book::class.java).equalTo("id", id).findFirst()
                    ?: return@executeTransaction
            book.imageId = imageId
            book.title = title
            book.author = author
            book.pageCount = pageCount
            book.description = description
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}