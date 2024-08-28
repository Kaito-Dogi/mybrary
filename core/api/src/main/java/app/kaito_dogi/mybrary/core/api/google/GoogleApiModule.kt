package app.kaito_dogi.mybrary.core.api.google

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

private const val GoogleApiBaseUrl = "https://www.googleapis.com/"

@Module
@InstallIn(SingletonComponent::class)
internal object GoogleApiModule {
  @Singleton
  @Provides
  fun provideGoogleApi(okHttpClient: OkHttpClient): GoogleApi {
    val contentType = "application/json; charset=UTF8".toMediaType()
    val format = Json { ignoreUnknownKeys = true }
    return Retrofit.Builder()
      .client(okHttpClient)
      .baseUrl(GoogleApiBaseUrl)
      .addConverterFactory(format.asConverterFactory(contentType))
      .build()
      .create(GoogleApi::class.java)
  }
}
