package app.kaito_dogi.mybrary.core.ui.browser

import android.graphics.BitmapFactory
import androidx.browser.customtabs.CustomTabColorSchemeParams
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.core.net.toUri
import app.kaito_dogi.mybrary.core.common.model.Url
import app.kaito_dogi.mybrary.core.designsystem.R
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme

interface InternalBrowserLauncher {
  fun launch(url: Url)
}

@Composable
fun rememberInternalBrowserLauncher(): InternalBrowserLauncher {
  val context = LocalContext.current

  val closeButtonIcon = remember(context) {
    BitmapFactory.decodeResource(
      context.resources,
      R.drawable.icon_arrow_back,
    )
  }

  val toolbarColor = MybraryTheme.colorScheme.surface.toArgb()
  val customTabColorSchemeParams = remember(toolbarColor) {
    CustomTabColorSchemeParams.Builder()
      .setToolbarColor(toolbarColor)
      .build()
  }

  val customTabsIntent = remember(
    closeButtonIcon,
    customTabColorSchemeParams,
  ) {
    CustomTabsIntent.Builder()
      .setShowTitle(true)
      .setCloseButtonIcon(closeButtonIcon)
      .setDefaultColorSchemeParams(customTabColorSchemeParams)
      .build()
  }

  val internalBrowserLauncher = remember {
    object : InternalBrowserLauncher {
      override fun launch(url: Url) {
        val uri = url.value.toUri()
        customTabsIntent.launchUrl(context, uri)
      }
    }
  }

  return internalBrowserLauncher
}
