package app.doggy.mybrary

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import app.doggy.mybrary.core.designsystem.theme.MybraryTheme
import app.doggy.mybrary.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding

  @OptIn(ExperimentalMaterial3Api::class)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    // binding = ActivityMainBinding.inflate(layoutInflater)
    // setContentView(binding.root)

    setContent {
      MybraryTheme {
        // FromBookModule()

        val sheetState = rememberModalBottomSheetState()
        var isModalShown by remember { mutableStateOf(false) }
        val hostState = remember { SnackbarHostState() }
        val scope = rememberCoroutineScope()
        var text by remember { mutableStateOf("") }

        Scaffold(
          snackbarHost = { SnackbarHost(hostState) },
        ) { paddingValues ->
          Column(modifier = Modifier.padding(paddingValues)) {
            Button(onClick = { isModalShown = true }) {
              Text(text = "Show Bottom Sheet")
            }

            Button(
              onClick = {
                scope.launch {
                  isModalShown = true
                  sheetState.hide()
                  sheetState.show()
                  sheetState.expand()
                }
              },
            ) {
              Text(text = "expand")
            }

            Button(
              onClick = {
                scope.launch {
                  hostState.showSnackbar("Message")
                }
              },
            ) {
              Text(text = "Show Snackbar")
            }

            if (isModalShown) {
              ModalBottomSheet(
                onDismissRequest = { isModalShown = false },
                sheetState = sheetState,
                modifier = Modifier.weight(1f)
              ) {
                Text(text = "あああ")
                TextField(value = text, onValueChange = { text = it })
                Button(
                  onClick = {
                    scope.launch {
                      sheetState.expand()
                    }
                  },
                ) {
                  Text(text = "expand")
                }
              }
            }
          }
        }
      }
    }
  }
}
