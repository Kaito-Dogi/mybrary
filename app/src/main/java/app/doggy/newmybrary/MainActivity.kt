package app.doggy.newmybrary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        readFab.setOnClickListener {
            val readIntent = Intent(baseContext, ReadActivity::class.java)
            startActivity(readIntent)
        }
    }
}