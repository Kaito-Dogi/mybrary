package app.kaito_dogi.mybrary.core.designsystem.ext

import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember

val ScrollableState.isScrolledToBottom: Boolean
  @Composable
  get() {
    val isScrolledToBottom by remember(key1 = this) {
      derivedStateOf { canScrollBackward && !canScrollForward }
    }
    return isScrolledToBottom
  }
