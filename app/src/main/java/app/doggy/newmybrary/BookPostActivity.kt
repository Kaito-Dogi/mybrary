package app.doggy.newmybrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import coil.api.load
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_book_post.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BookPostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_post)

        val isbn: String? = intent.getStringExtra("isbn")

        val gson: Gson =
            GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://www.googleapis.com/books/v1/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        val bookFromIsbnService: BookDataService = retrofit.create(BookDataService::class.java)

        runBlocking(Dispatchers.IO) {
            runCatching {
                bookFromIsbnService.getBook("isbn:$isbn")
            }
        }.onSuccess {
            bookImage.load(it.items[0].volumeInfo.imageLinks.thumbnail)
            titleEditText.setText(it.items[0].volumeInfo.title)
            authorEditText.setText(it.items[0].volumeInfo.authors[0])
            descriptionEditText.setText(it.items[0].volumeInfo.description)
            pageCountEditText.setText(it.items[0].volumeInfo.pageCount.toString())
            Toast.makeText(applicationContext, getText(R.string.on_success), Toast.LENGTH_SHORT).show()
        }.onFailure {
            Toast.makeText(applicationContext, getText(R.string.on_failure), Toast.LENGTH_SHORT).show()
        }

    }
}