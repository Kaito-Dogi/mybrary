package app.doggy.newmybrary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import coil.api.load
import io.realm.Realm
import io.realm.RealmResults
import io.realm.Sort
import kotlinx.android.synthetic.main.activity_record.*
import java.util.*

class RecordActivity : AppCompatActivity() {

    private val realm: Realm by lazy {
        Realm.getDefaultInstance()
    }

    var bookTitle = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_record)

        val bookId = intent.getStringExtra("bookId")
        val book = realm.where(Book::class.java).equalTo("bookId", bookId).findFirst()
        bookImageInRecord.load(book?.imageId)

        bookTitle = book?.title as String
        titleText.text = bookTitle

        authorText.text = book?.author
        pageCountText.text = "p${book?.pageCount.toString()}"
        descriptionText.text = book?.description

        val recordList = readAll()

        val adapter = RecordAdapter(this, recordList, object: RecordAdapter.OnItemClickListener {
            override fun onItemClick(item: Record) {
                // クリック時の処理
                Toast.makeText(applicationContext, item.comment1 + "を削除しました", Toast.LENGTH_SHORT).show()
                delete(item.id)
            }
        },true)

        recordRecyclerView.setHasFixedSize(true)
        recordRecyclerView.layoutManager = LinearLayoutManager(this)
        recordRecyclerView.adapter = adapter

        recordPostFab.setOnClickListener {
            val postIntent = Intent(baseContext, RecordPostActivity::class.java)
            postIntent.putExtra("bookTitle", book?.title)
            startActivity(postIntent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }

    private fun readAll(): RealmResults<Record> {
        return realm.where(Record::class.java)
            .equalTo("bookTitle", bookTitle)
            .findAll()
            .sort("createdAt", Sort.DESCENDING)
    }

    fun delete(id: String) {
        realm.executeTransaction {
            val task = realm.where(Record::class.java).equalTo("id", id).findFirst()
                ?: return@executeTransaction
            task.deleteFromRealm()
        }
    }

}