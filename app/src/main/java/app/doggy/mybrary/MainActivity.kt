package app.doggy.mybrary

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import app.doggy.mybrary.databinding.ActivityMainBinding
import app.doggy.mybrary.feature.book.FromBookModule
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    // binding = ActivityMainBinding.inflate(layoutInflater)
    // setContentView(binding.root)

    setContent {
      FromBookModule()
    }
  }
}
