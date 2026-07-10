package app.kaito_dogi.mybrary.core.ui.browser

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.core.net.toUri
import app.kaito_dogi.mybrary.core.common.model.Url

interface ExternalBrowserLauncher {
  fun launch(url: Url)
}

@Composable
fun rememberExternalBrowserLauncher(): ExternalBrowserLauncher {
  val context = LocalContext.current

  val externalBrowserLauncher = remember {
    object : ExternalBrowserLauncher {
      override fun launch(url: Url) {
        val intent = Intent(Intent.ACTION_VIEW, url.value.toUri())
        context.startActivity(intent)
      }
    }
  }

  return externalBrowserLauncher
}
