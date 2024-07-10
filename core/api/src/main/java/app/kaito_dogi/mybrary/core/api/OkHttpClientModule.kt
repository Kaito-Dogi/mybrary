package app.kaito_dogi.mybrary.core.api

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import okhttp3.Interceptor
import okhttp3.OkHttpClient

private const val ConnectTimeOut = 60L
private const val ReadTimeOut = 60L

@Module
@InstallIn(SingletonComponent::class)
internal object OkHttpClientModule {
  @Singleton
  @Provides
  fun provideOkHttpClient(
    @OkHttpInterceptor interceptorSet: MutableSet<Interceptor>,
  ): OkHttpClient = OkHttpClient.Builder()
    .connectTimeout(ConnectTimeOut, TimeUnit.SECONDS)
    .readTimeout(ReadTimeOut, TimeUnit.SECONDS)
    .apply {
      for (interceptor in interceptorSet) {
        addInterceptor(interceptor)
      }
    }.build()
}
