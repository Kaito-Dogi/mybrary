package app.kaito_dogi.mybrary.feature.auth.destination.sendotp.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.component.Text
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.ui.R

@Composable
internal fun LogoSection(
  modifier: Modifier = Modifier,
) {
  Box(
    modifier = modifier.fillMaxWidth(),
    contentAlignment = Alignment.Center,
  ) {
    Text(
      text = stringResource(id = R.string.send_otp_text_logo),
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
