package app.kaito_dogi.mybrary.feature.login.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme

@Composable
internal fun LogoSection(
  modifier: Modifier = Modifier,
) {
  Box(
    modifier = modifier.fillMaxWidth(),
    contentAlignment = Alignment.Center,
  ) {
    Text(
      text = "Mybrary",
      style = MybraryTheme.typography.displaySmall,
    )
  }
}

@Preview
@Composable
private fun LogoSectionPreview() {
  MybraryTheme {
    LogoSection()
  }
}
