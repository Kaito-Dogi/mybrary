package app.kaito_dogi.mybrary.core.api

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
  fun provideOkHttpClient(
    @OkHttpInterceptor interceptorSet: MutableSet<Interceptor>,
  ): OkHttpClient = OkHttpClient.Builder()
    .connectTimeout(ConnectTimeOut, TimeUnit.SECONDS)
    .readTimeout(ReadTimeOut, TimeUnit.SECONDS)
    .addInterceptor(
      // TODO: ここで add するか検討（デバッグ環境のみ add すれば良い）
      HttpLoggingInterceptor()
        .apply {
          if (BuildConfig.DEBUG) {
            setLevel(HttpLoggingInterceptor.Level.BODY)
          }
        },
    )
    // TODO: API に成功したかどうかを確認するための Interceptor を実装したい
    .apply {
      for (interceptor in interceptorSet) {
        addInterceptor(interceptor)
      }
    }
    .build()
}
