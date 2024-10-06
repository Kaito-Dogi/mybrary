package app.kaito_dogi.core.hcaptcha

import com.hcaptcha.sdk.HCaptchaConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object HCaptchaConfigModule {
  @Singleton
  @Provides
  fun provideHCaptchaConfig(
    builder: HCaptchaConfig.HCaptchaConfigBuilder,
  ): HCaptchaConfig = builder
    .diagnosticLog(true)
    .build()
}
