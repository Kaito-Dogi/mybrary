package app.kaito_dogi.mybrary.core.supabase

import app.kaito_dogi.mybrary.core.api.mybrary.MybraryAuthApi
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface MybraryAuthApiModule {
  @Singleton
  @Binds
  fun bindMybraryAuthApi(impl: MybraryAuthApiImpl): MybraryAuthApi
}
