package app.doggy.newmybrary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.activity_read.*

class ReadActivity : AppCompatActivity() {

    private var qrScanIntegrator: IntentIntegrator? = null

    lateinit var isbnEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read)

        isbnEditText = findViewById(R.id.isbnEditText)

        //バーコードリーダーを起動。
        qrScanIntegrator = IntentIntegrator(this)
        qrScanIntegrator?.setOrientationLocked(false)
        qrScanIntegrator?.setBeepEnabled(false)
        qrScanIntegrator?.initiateScan()

        requestButton.setOnClickListener {

            val postIntent = Intent(baseContext, BookPostActivity::class.java)

            val isbn = isbnEditText.text.toString()
            postIntent.putExtra("isbn", isbn)

            startActivity(postIntent)
        }
    }

    //バーコード読み取り後に呼ばれるメソッド。
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)

        if (result != null) {
            isbnEditText.setText(result.contents)
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }

    }
}