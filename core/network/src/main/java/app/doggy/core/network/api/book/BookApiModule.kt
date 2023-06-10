package app.doggy.core.network.api.book

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
private interface BookApiModule {

  @Binds
  fun bindBookApi(impl: BookApiImpl): BookApi
}
