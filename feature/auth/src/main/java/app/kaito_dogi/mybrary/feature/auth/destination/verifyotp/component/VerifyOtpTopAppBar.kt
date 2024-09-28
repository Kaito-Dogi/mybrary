package app.kaito_dogi.mybrary.feature.auth.destination.verifyotp.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.component.Icon
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.ui.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun VerifyOtpTopAppBar(
  onNavigationIconClick: () -> Unit,
) {
  MediumTopAppBar(
    title = {
      Text(text = stringResource(id = R.string.verify_otp_text_verify_otp))
    },
    navigationIcon = {
      IconButton(
        onClick = onNavigationIconClick,
      ) {
        Icon(
          iconResId = R.drawable.icon_arrow_back,
          altResId = R.string.verify_otp_back,
        )
      }
    },
  )
}

@Preview
@Composable
private fun VerifyOtpTopAppBarPreview() {
  MybraryTheme {
    VerifyOtpTopAppBar(
      onNavigationIconClick = {},
    )
  }
}
