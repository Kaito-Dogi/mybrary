package app.doggy.newmybrary

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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

    var bookId = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_record)

        supportActionBar?.hide()

    }

    override fun onResume() {
        super.onResume()
        bookId = intent.getStringExtra("bookId") as String
        val book = realm.where(Book::class.java).equalTo("id", bookId).findFirst()

        if (book?.imageId == "") {
            bookImageInRecord.setImageResource(R.drawable.book_black)
        } else {
            bookImageInRecord.load(book?.imageId)
        }

        titleText.text = book?.title
        authorText.text = book?.author
        pageCountText.text = "${book?.pageCount}" + getText(R.string.total_page_text)
        descriptionText.text = book?.description

        val recordList = readAll()

        val adapter = RecordAdapter(this, recordList, object: RecordAdapter.OnItemClickListener {
            override fun onItemClick(item: Record) {

            }
        },true)

        recordRecyclerView.setHasFixedSize(true)
        recordRecyclerView.layoutManager = LinearLayoutManager(this)
        recordRecyclerView.adapter = adapter

        recordPostFab.setOnClickListener {
            val postIntent = Intent(baseContext, RecordPostActivity::class.java)
            postIntent.putExtra("bookId", book?.id)
            postIntent.putExtra("bookPageCount", book?.pageCount)
            startActivity(postIntent)
        }

        recordAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.edit -> {
                    val postIntent = Intent(baseContext, BookPostActivity::class.java)
                    postIntent.putExtra("id", book?.id)
                    startActivity(postIntent)
                    true
                }
                R.id.delete -> {
                    AlertDialog
                            .Builder(this@RecordActivity)
                            .setMessage(R.string.delete_dialog_message)
                            .setPositiveButton(getText(R.string.delete_dialog_positive_button)) { dialog, which ->
                                Toast.makeText(baseContext, getText(R.string.delete_toast_text_before).toString() + book?.title + getText(R.string.delete_toast_text_after), Toast.LENGTH_SHORT).show()
                                realm.executeTransaction {
                                    val records = realm.where(Record::class.java).equalTo("bookId", bookId).findAll()
                                            ?: return@executeTransaction
                                    records.deleteAllFromRealm()
                                    book?.deleteFromRealm()
                                }
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

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }

    private fun readAll(): RealmResults<Record> {
        return realm.where(Record::class.java)
            .equalTo("bookId", bookId)
            .findAll()
            .sort("createdAt", Sort.DESCENDING)
    }

}