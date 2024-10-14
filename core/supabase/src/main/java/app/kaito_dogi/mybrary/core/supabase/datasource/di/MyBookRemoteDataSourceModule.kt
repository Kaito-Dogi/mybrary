package app.kaito_dogi.mybrary.core.supabase.datasource.di

import app.kaito_dogi.mybrary.core.data.datasource.MyBookRemoteDataSource
import app.kaito_dogi.mybrary.core.supabase.datasource.DefaultMyBookRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface MyBookRemoteDataSourceModule {
  @Singleton
  @Binds
  fun bindMyBookRemoteDataSource(impl: DefaultMyBookRemoteDataSource): MyBookRemoteDataSource
}
