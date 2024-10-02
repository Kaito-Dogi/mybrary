package app.kaito_dogi.mybrary

import app.kaito_dogi.mybrary.core.common.model.Url
import app.kaito_dogi.mybrary.core.config.MybraryConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object MybraryConfigModule {
  @Singleton
  @Provides
  fun provideMybraryConfig(): MybraryConfig = object : MybraryConfig {
    override val deleteAccountUrl: Url.Web = Url.Web(value = BuildConfig.DELETE_ACCOUNT_URL)
    override val privacyPolicyUrl: Url.Web = Url.Web(value = BuildConfig.PRIVACY_POLICY_URL)
    override val rakutenApplicationId: String = BuildConfig.RAKUTEN_APPLICATION_ID
    override val rakutenAffiliateId: String = BuildConfig.RAKUTEN_AFFILIATE_ID
    override val rakutenDevelopersUrl: Url.Web = Url.Web(value = BuildConfig.RAKUTEN_DEVELOPERS_URL)
    override val supabaseUrl: String = BuildConfig.SUPABASE_URL
    override val supabaseKey: String = BuildConfig.SUPABASE_KEY
    override val termsOfUseUrl: Url.Web = Url.Web(value = BuildConfig.TERMS_OF_USE)
    override val versionName: String = BuildConfig.VERSION_NAME
  }
}
