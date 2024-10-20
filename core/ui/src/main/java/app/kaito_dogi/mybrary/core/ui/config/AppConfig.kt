package app.kaito_dogi.mybrary.core.ui.config

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import app.kaito_dogi.mybrary.core.config.AppConfig
import dagger.hilt.android.EntryPointAccessors

@Composable
fun rememberAppConfig(): AppConfig {
  val context = LocalContext.current
  val appConfigEntryPoint: AppConfigEntryPoint = remember(context) {
    EntryPointAccessors.fromApplication(context)
  }
  return appConfigEntryPoint.appConfig
}
