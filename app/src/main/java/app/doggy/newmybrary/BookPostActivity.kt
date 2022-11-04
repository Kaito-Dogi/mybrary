package app.doggy.newmybrary

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import app.doggy.newmybrary.databinding.ActivityBookPostBinding
import coil.load
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.hilt.android.AndroidEntryPoint
import io.realm.Realm
import java.util.UUID
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit

@AndroidEntryPoint
class BookPostActivity : AppCompatActivity() {

  private lateinit var binding: ActivityBookPostBinding

  private val realm: Realm by lazy {
    Realm.getDefaultInstance()
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityBookPostBinding.inflate(layoutInflater)
    setContentView(binding.root)

    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.setDisplayShowTitleEnabled(false)

    val isbn: String? = intent.getStringExtra("isbn")

    val gson: Gson =
      GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()
    val retrofit: Retrofit = Retrofit.Builder()
      .baseUrl("https://www.googleapis.com/books/v1/")
      // .addConverterFactory(GsonConverterFactory.create(gson))
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
          binding.bookImageInPost.load(imageId)
          binding.titleEditText.setText(it.items[0].volumeInfo.title)
          binding.authorEditText.setText(it.items[0].volumeInfo.authors[0])
          binding.pageCountEditText.setText(it.items[0].volumeInfo.pageCount.toString())
          binding.descriptionEditText.setText(it.items[0].volumeInfo.description)
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
      binding.bookAddButton.setText(R.string.book_update_button)

      val book = realm.where(BookEntity::class.java).equalTo("id", id).findFirst()
      if (book?.imageId != "") {
        imageId = book?.imageId as String
        binding.bookImageInPost.load(imageId)
      }
      binding.titleEditText.setText(book.title)
      binding.authorEditText.setText(book.author)
      binding.pageCountEditText.setText(book.pageCount.toString())
      binding.descriptionEditText.setText(book.description)
    }

    binding.bookAddButton.setOnClickListener {
      if (binding.pageCountEditText.text.toString() != "" &&
        binding.pageCountEditText.text.toString().toInt() > 0 &&
        binding.titleEditText.text.toString() != ""
      ) {
        if (id == null) {
          create(
            imageId,
            binding.titleEditText.text.toString(),
            binding.authorEditText.text.toString(),
            binding.pageCountEditText.text.toString().toInt(),
            binding.descriptionEditText.text.toString(),
          )
        } else {
          update(
            id,
            imageId,
            binding.titleEditText.text.toString(),
            binding.authorEditText.text.toString(),
            binding.pageCountEditText.text.toString().toInt(),
            binding.descriptionEditText.text.toString(),
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
      val book = it.createObject(BookEntity::class.java, UUID.randomUUID().toString())
      book.imageId = imageId
      book.title = title
      book.author = author
      book.pageCount = pageCount
      book.description = description
    }
  }

  private fun update(id: String, imageId: String, title: String, author: String, pageCount: Int, description: String) {
    realm.executeTransaction {
      val book = realm.where(BookEntity::class.java).equalTo("id", id).findFirst()
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
