package app.doggy.mybrary.core.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
  primary = Primary,
  onPrimary = OnPrimary,
  primaryContainer = PrimaryContainer,
  background = SurfaceDim,
  surface = Surface,
  surfaceVariant = SurfaceContainer,
  onSurface = OnSurface,
  onSurfaceVariant = OnSurfaceVariant,
  inverseSurface = InverseSurface,
  inverseOnSurface = InverseOnSurface,
  outline = Outline,
)

private val LightColorScheme = lightColorScheme(
  primary = Primary,
  onPrimary = OnPrimary,
  primaryContainer = PrimaryContainer,
  background = SurfaceDim,
  surface = Surface,
  surfaceVariant = SurfaceContainer,
  onSurface = OnSurface,
  onSurfaceVariant = OnSurfaceVariant,
  inverseSurface = InverseSurface,
  inverseOnSurface = InverseOnSurface,
  outline = Outline,
)

@Composable
fun MybraryTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  dynamicColor: Boolean = false,
  content: @Composable () -> Unit,
) {
  val colorScheme = when {
    dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
      val context = LocalContext.current
      if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
    }

    darkTheme -> DarkColorScheme
    else -> LightColorScheme
  }

  // TODO: ステータスバーの設定が必要か調査する
  val view = LocalView.current
  if (!view.isInEditMode) {
    SideEffect {
      val window = (view.context as Activity).window
      window.statusBarColor = colorScheme.primary.toArgb()
      WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
    }
  }

  MaterialTheme(
    colorScheme = colorScheme,
    typography = Typography,
    content = content,
  )
}
