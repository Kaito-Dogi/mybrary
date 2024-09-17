package app.kaito_dogi.mybrary.feature.setting.destination.settinglist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import app.kaito_dogi.mybrary.core.designsystem.component.Text

@Composable
internal fun SettingListScreenContainer() {
  Box(
    modifier = Modifier
      .fillMaxSize()
      .padding(WindowInsets.navigationBars.asPaddingValues()),
    contentAlignment = Alignment.Center,
  ) {
    Text(text = "SettingList")
  }
}
