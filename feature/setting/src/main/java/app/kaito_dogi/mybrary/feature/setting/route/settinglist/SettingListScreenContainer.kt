package app.kaito_dogi.mybrary.feature.setting.route.settinglist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import app.kaito_dogi.mybrary.core.designsystem.component.Text

@Composable
internal fun SettingListScreenContainer() {
  Box(
    modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center,
  ) {
    Text(text = "SettingList")
  }
}
