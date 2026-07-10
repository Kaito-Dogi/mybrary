package app.kaito_dogi.mybrary.core.ui.sns

import android.content.Context
import android.content.Intent
import java.net.URLEncoder
import androidx.core.net.toUri

private const val XShareUrl = "https://twitter.com/intent/tweet?text=%s"

fun Context.shareTextToX(text: String) {
  val encodedText = URLEncoder.encode(text, Charsets.UTF_8.name())
  val intent = Intent(
    Intent.ACTION_VIEW,
    XShareUrl.format(encodedText).toUri(),
  )
  startActivity(intent)
}
