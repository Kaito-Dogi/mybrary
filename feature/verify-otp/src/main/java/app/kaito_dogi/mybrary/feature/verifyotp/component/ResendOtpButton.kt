package app.kaito_dogi.mybrary.feature.verifyotp.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import app.kaito_dogi.mybrary.core.designsystem.R
import app.kaito_dogi.mybrary.core.designsystem.component.TertiaryButton
import kotlinx.coroutines.delay

private const val INITIAL_COUNTDOWN_SECOND = 60

@Composable
fun ResendOtpButton(
  onClick: () -> Unit,
  isLoading: Boolean,
  modifier: Modifier = Modifier,
) {
  val (countdownSecond, setCountdownSecond) = remember {
    mutableIntStateOf(INITIAL_COUNTDOWN_SECOND)
  }

  LaunchedEffect(countdownSecond) {
    if (countdownSecond > 0) {
      delay(1_000L)
      setCountdownSecond(countdownSecond - 1)
    }
  }

  TertiaryButton(
    text = if (countdownSecond > 0) {
      stringResource(
        id = R.string.verify_otp_text_resend_otp_in_seconds,
        countdownSecond,
      )
    } else {
      stringResource(id = R.string.verify_otp_text_resend_otp)
    },
    onClick = onClick,
    modifier = modifier,
    isLoading = isLoading,
    isEnabled = countdownSecond == 0,
  )
}
