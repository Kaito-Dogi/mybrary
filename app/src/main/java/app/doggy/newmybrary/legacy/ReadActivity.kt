package app.doggy.newmybrary.legacy

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import app.doggy.newmybrary.R
import app.doggy.newmybrary.databinding.ActivityReadBinding
import com.google.zxing.integration.android.IntentIntegrator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReadActivity : AppCompatActivity() {

  private lateinit var binding: ActivityReadBinding

  private var qrScanIntegrator: IntentIntegrator? = null

  lateinit var isbnEditText: EditText

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityReadBinding.inflate(layoutInflater)
    setContentView(binding.root)

    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.setDisplayShowTitleEnabled(false)

    isbnEditText = findViewById(R.id.isbnEditText)

    // バーコードリーダーを起動。
    qrScanIntegrator = IntentIntegrator(this)
    qrScanIntegrator?.setOrientationLocked(false)
    qrScanIntegrator?.setBeepEnabled(false)
    qrScanIntegrator?.initiateScan()

    binding.requestButton.setOnClickListener {
      val postIntent = Intent(baseContext, BookPostActivity::class.java)

      val isbn = isbnEditText.text.toString()
      postIntent.putExtra("isbn", isbn)

      startActivity(postIntent)

      finish()
    }
  }

  // バーコード読み取り後に呼ばれるメソッド。
  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)

    if (result != null) {
      isbnEditText.setText(result.contents)
    } else {
      super.onActivityResult(requestCode, resultCode, data)
    }
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    if (item.itemId == android.R.id.home) {
      finish()
    }
    return super.onOptionsItemSelected(item)
  }
}
