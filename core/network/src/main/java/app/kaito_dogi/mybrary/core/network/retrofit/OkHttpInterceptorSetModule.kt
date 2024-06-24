package app.kaito_dogi.mybrary.core.network.retrofit

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.Multibinds
import okhttp3.Interceptor

@Module
@InstallIn(SingletonComponent::class)
internal interface OkHttpInterceptorSetModule {
  @OkHttpInterceptor
  @Multibinds
  fun bindInterceptorSet(): MutableSet<Interceptor>
}
