package app.kaito_dogi.mybrary.core.config

import app.kaito_dogi.mybrary.core.common.model.Url

interface AppConfig {
  val privacyPolicyUrl: Url.Web
  val rakutenApplicationId: String
  val rakutenAffiliateId: String
  val rakutenDevelopersUrl: Url.Web
  val termsOfUseUrl: Url.Web
  val versionName: String
}
