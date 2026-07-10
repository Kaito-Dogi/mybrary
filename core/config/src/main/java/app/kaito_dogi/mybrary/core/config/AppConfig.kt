package app.kaito_dogi.mybrary.core.config

import app.kaito_dogi.mybrary.core.common.model.Url

interface AppConfig {
  val privacyPolicyUrl: Url.Web
  val rakutenAccessKey: String
  val rakutenApplicationId: String
  val rakutenAffiliateId: String
  val rakutenDevelopersUrl: Url.Web
  val rakutenReferer: String
  val termsOfUseUrl: Url.Web
  val versionName: String
}
