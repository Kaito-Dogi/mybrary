package app.kaito_dogi.core.hcaptcha

import com.hcaptcha.sdk.HCaptchaConfig
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface HCaptchaConfigEntryPoint {
  val hCaptchaConfig: HCaptchaConfig
}
