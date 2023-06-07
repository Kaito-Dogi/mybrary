package app.doggy.mybrary.data.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Singleton
class RetrofitManager @Inject constructor() {
  private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

  private val okHttpClient = OkHttpClient.Builder()
    .connectTimeout(60, TimeUnit.SECONDS)
    .readTimeout(60, TimeUnit.SECONDS)
    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
    .build()

  val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl(BaseUrl.BOOK_BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .client(okHttpClient)
    .build()
}
