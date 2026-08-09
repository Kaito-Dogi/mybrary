package app.kaito_dogi.mybrary.core.ui.share

import android.content.Context
import android.content.Intent

// https://developer.android.com/training/sharing/send#send-text-content
fun Context.shareText(text: String) {
  val shareIntent = Intent(Intent.ACTION_SEND).apply {
    type = "text/plain"
    putExtra(Intent.EXTRA_TEXT, text)
  }
  startActivity(Intent.createChooser(shareIntent, null))
}
