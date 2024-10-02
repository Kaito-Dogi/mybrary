package app.kaito_dogi.mybrary.core.config

import app.kaito_dogi.mybrary.core.common.model.Url

interface MybraryConfig {
  val deleteAccountUrl: Url.Web
  val privacyPolicyUrl: Url.Web
  val rakutenApplicationId: String
  val rakutenAffiliateId: String
  val rakutenDevelopersUrl: Url.Web
  val supabaseUrl: String
  val supabaseKey: String
  val termsOfUseUrl: Url.Web
  val versionName: String
}
