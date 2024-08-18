package app.kaito_dogi.mybrary.core.supabase.api

import app.kaito_dogi.mybrary.core.api.mybrary.MybraryAnonApi
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface MybraryAnonApiModule {
  @Singleton
  @Binds
  fun bindMybraryAnonApi(impl: MybraryAnonApiImpl): MybraryAnonApi
}
