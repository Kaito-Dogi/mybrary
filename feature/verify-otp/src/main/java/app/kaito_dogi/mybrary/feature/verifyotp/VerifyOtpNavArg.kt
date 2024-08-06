package app.kaito_dogi.mybrary.feature.verifyotp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class VerifyOtpNavArg(
  val source: VerifyOtpSource,
) : Parcelable

enum class VerifyOtpSource {
  Login,
  SignUp,
}
