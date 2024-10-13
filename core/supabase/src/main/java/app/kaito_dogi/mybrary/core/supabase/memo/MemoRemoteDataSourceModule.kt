package app.kaito_dogi.mybrary.core.supabase.memo

import app.kaito_dogi.mybrary.core.data.datasource.MemoRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface MemoRemoteDataSourceModule {
  @Singleton
  @Binds
  fun bindMemoRemoteDataSource(impl: DefaultMemoRemoteDataSource): MemoRemoteDataSource
}
