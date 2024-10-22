package app.kaito_dogi.core.hcaptcha

import app.kaito_dogi.mybrary.core.config.AppConfig
import com.hcaptcha.sdk.HCaptchaConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object HCaptchaConfigBuilderModule {
  @Singleton
  @Provides
  fun provideHCaptchaConfigBuilder(
    appConfig: AppConfig,
  ): HCaptchaConfig.HCaptchaConfigBuilder = HCaptchaConfig.builder()
    .siteKey(appConfig.hCaptchaSiteKey)
}
