package app.kaito_dogi.core.hcaptcha

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import app.kaito_dogi.mybrary.core.domain.model.HCaptchaToken
import com.hcaptcha.sdk.HCaptchaCompose
import com.hcaptcha.sdk.HCaptchaEvent
import com.hcaptcha.sdk.HCaptchaResponse
import dagger.hilt.android.EntryPointAccessors

@Composable
fun HCaptchaDialog(
  onSuccess: (HCaptchaToken) -> Unit,
  onFailure: () -> Unit,
) {
  val context = LocalContext.current
  val hCaptchaConfigEntryPoint: HCaptchaConfigEntryPoint = remember(context) {
    EntryPointAccessors.fromApplication(context)
  }
  HCaptchaCompose(
    config = hCaptchaConfigEntryPoint.hCaptchaConfig,
    onResult = { result ->
      when (result) {
        is HCaptchaResponse.Event -> {
          when (result.event) {
            HCaptchaEvent.Loaded -> {
              // 何もしない
            }

            HCaptchaEvent.Opened -> {
              // 何もしない
            }
          }
        }

        is HCaptchaResponse.Failure -> {
          onFailure()
        }

        is HCaptchaResponse.Success -> {
          val hCaptchaToken = HCaptchaToken(value = result.token)
          onSuccess(hCaptchaToken)
        }
      }
    },
  )
}
