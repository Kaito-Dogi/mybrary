package app.kaito_dogi.mybrary.core.network.retrofit

import app.kaito_dogi.mybrary.core.network.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

private const val ConnectTimeOut = 60L
private const val ReadTimeOut = 60L

@Module
@InstallIn(SingletonComponent::class)
internal object OkHttpClientModule {
  @Singleton
  @Provides
  fun providesOkHttpClient(
    @OkHttpInterceptor interceptorSet: MutableSet<Interceptor>,
  ): OkHttpClient = OkHttpClient.Builder()
    .connectTimeout(ConnectTimeOut, TimeUnit.SECONDS)
    .readTimeout(ReadTimeOut, TimeUnit.SECONDS)
    .addInterceptor(
      HttpLoggingInterceptor()
        .apply {
          if (BuildConfig.DEBUG) {
            setLevel(HttpLoggingInterceptor.Level.BODY)
          }
        },
    )
    .apply {
      for (interceptor in interceptorSet) {
        addInterceptor(interceptor)
      }
    }
    .build()
}
