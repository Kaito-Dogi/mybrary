package app.doggy.core.network.retrofit

import app.doggy.core.network.retrofit.service.BookService
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

private const val BASE_URL = "https://www.googleapis.com/books/v1/"

@Module
@InstallIn(SingletonComponent::class)
private object RetrofitModule {

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

  @Provides
  @Singleton
  fun provideBookService(
    retrofit: Retrofit,
  ): BookService = retrofit.create()
}
