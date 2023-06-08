package app.doggy.core.network.book

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
object BookApiModule {

  @Provides
  @Singleton
  fun provideBookApi(
    retrofit: Retrofit,
  ): BookApi = retrofit.create()
}
