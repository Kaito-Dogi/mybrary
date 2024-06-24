package app.kaito_dogi.mybrary.core.network.retrofit

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://www.googleapis.com/books/v1/"

@Module
@InstallIn(SingletonComponent::class)
internal object RetrofitModule {
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

//  @Provides
//  @Singleton
//  fun provideBookService(
//    retrofit: Retrofit,
//  ): BookService = retrofit.create()
}
