package app.doggy.core.network.di

import app.doggy.core.network.BuildConfig
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
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://www.googleapis.com/books/v1/"

private const val CONNECT_TIME_OUT = 60L
private const val READ_TIME_OUT = 60L

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

  @Provides
  @Singleton
  fun provideMoshi(): Moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

  @Provides
  @Singleton
  fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
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

  @Provides
  @Singleton
  fun provideRetrofit(
    moshi: Moshi,
    okHttpClient: OkHttpClient,
  ): Retrofit = Retrofit.Builder()
    .client(okHttpClient)
    .baseUrl(BASE_URL)
    .addConverterFactory(
      MoshiConverterFactory.create(moshi),
    )
    .build()
}
