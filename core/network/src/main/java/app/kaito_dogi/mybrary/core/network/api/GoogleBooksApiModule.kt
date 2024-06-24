package app.kaito_dogi.mybrary.core.network.api

import app.kaito_dogi.mybrary.core.network.retrofit.GoogleBooksRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
internal object GoogleBooksApiModule {
  @Singleton
  @Provides
  fun provideGoogleBooksApi(
    @GoogleBooksRetrofit retrofit: Retrofit,
  ): GoogleBooksApi = retrofit.create(GoogleBooksApi::class.java)
}
