package app.kaito_dogi.mybrary.core.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

private const val CONNECT_TIME_OUT = 60L
private const val READ_TIME_OUT = 60L

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {
  @Singleton
  @Provides
  fun providesMoshi(): Moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

  @Singleton
  @Provides
  fun providesOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
    .connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS)
    .readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)
    .addInterceptor(
      HttpLoggingInterceptor()
        .apply {
          if (BuildConfig.DEBUG) {
            setLevel(HttpLoggingInterceptor.Level.BODY)
          }
        },
    )
    .build()
}
