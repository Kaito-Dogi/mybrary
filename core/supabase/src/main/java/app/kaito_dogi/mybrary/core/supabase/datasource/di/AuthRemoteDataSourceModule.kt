package app.kaito_dogi.mybrary.core.supabase.datasource.di

import app.kaito_dogi.mybrary.core.data.datasource.AuthRemoteDataSource
import app.kaito_dogi.mybrary.core.supabase.datasource.DefaultAuthRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface AuthRemoteDataSourceModule {
  @Singleton
  @Binds
  fun bindAuthRemoteDataSource(impl: DefaultAuthRemoteDataSource): AuthRemoteDataSource
}
