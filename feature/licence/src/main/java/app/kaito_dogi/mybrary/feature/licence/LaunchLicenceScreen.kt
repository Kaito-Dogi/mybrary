package app.kaito_dogi.mybrary.feature.licence

import android.app.Activity
import android.content.Context
import android.content.Intent
import app.kaito_dogi.mybrary.core.designsystem.theme.mybraryDarkColorScheme
import app.kaito_dogi.mybrary.core.designsystem.theme.mybraryLightColorScheme
import app.kaito_dogi.mybrary.core.designsystem.theme.mybraryTypography
import com.google.android.gms.oss.licenses.v2.OssLicensesMenuActivity

fun Context.launchLicenceScreen() {
  OssLicensesMenuActivity.setTheme(
    mybraryLightColorScheme,
    mybraryDarkColorScheme,
    mybraryTypography,
  )
  val intent = Intent(this, OssLicensesMenuActivity::class.java).apply {
    if (this@launchLicenceScreen !is Activity) {
      addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
  }
  startActivity(intent)
}
