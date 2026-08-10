package app.kaito_dogi.mybrary.core.ui.share

import android.content.Context
import android.content.Intent

// https://developer.android.com/training/sharing/send#send-text-content
fun Context.shareText(text: String) {
  val shareIntent = Intent(Intent.ACTION_SEND).apply {
    type = "text/plain"
    putExtra(Intent.EXTRA_TEXT, text)
  }
  val chooser = Intent.createChooser(shareIntent, null).apply {
    if (this@shareText !is android.app.Activity) {
      addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
  }
  try {
    startActivity(chooser)
  } catch (_: android.content.ActivityNotFoundException) {
    // do nothing
  }
}
