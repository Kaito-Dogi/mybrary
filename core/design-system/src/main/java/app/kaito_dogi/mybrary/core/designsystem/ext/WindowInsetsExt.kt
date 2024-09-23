package app.kaito_dogi.mybrary.core.designsystem.ext

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.runtime.Composable

val WindowInsets.Companion.none: WindowInsets
  @Composable
  get() = WindowInsets(0, 0, 0, 0)
