package app.kaito_dogi.mybrary.core.network.api.book

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface BookApiModule {

  @Binds
  fun bindBookApi(impl: BookApiImpl): BookApi
}
