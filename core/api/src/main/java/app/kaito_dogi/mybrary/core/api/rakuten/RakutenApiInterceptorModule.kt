package app.kaito_dogi.mybrary.core.api.rakuten

import app.kaito_dogi.mybrary.core.api.OkHttpInterceptor
import app.kaito_dogi.mybrary.core.config.AppConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import javax.inject.Singleton
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.Interceptor
import okhttp3.Response

@Module
@InstallIn(SingletonComponent::class)
internal object RakutenApiInterceptorModule {
  @OkHttpInterceptor
  @IntoSet
  @Singleton
  @Provides
  fun provideRakutenApiInterceptor(appConfig: AppConfig): Interceptor = RakutenApiInterceptor(
    appConfig = appConfig,
  )
}

private class RakutenApiInterceptor(
  private val appConfig: AppConfig,
) : Interceptor {
  override fun intercept(chain: Interceptor.Chain): Response {
    val request = chain.request()
    val newRequest = if (request.url.host == RakutenApiHost) {
      request.newBuilder()
        .header(name = "accessKey", value = appConfig.rakutenAccessKey)
        .apply {
          // REQUEST_CONTEXT_BODY_HTTP_REFERRER_MISSING は実際には Origin ヘッダで検証されるため、
          // アプリ登録済みサイトの URL からオリジンを導出して付与する
          appConfig.rakutenReferer.toHttpUrlOrNull()?.let { refererUrl ->
            header(name = "Origin", value = "${refererUrl.scheme}://${refererUrl.host}")
          }
        }
        .build()
    } else {
      request
    }
    return chain.proceed(request = newRequest)
  }
}
