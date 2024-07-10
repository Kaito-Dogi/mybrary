package app.kaito_dogi.mybrary.core.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

@Composable
fun MybraryTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  content: @Composable () -> Unit,
) {
  val colorScheme = if (darkTheme) {
    mybraryDarkColorScheme
  } else {
    mybraryLightColorScheme
  }

  CompositionLocalProvider(
    LocalDimens provides mybraryDimens,
    LocalSpace provides mybrarySpace,
  ) {
    MaterialTheme(
      // FIXME: カラースキーマをカスタムで定義する
//      colorScheme = colorScheme,
      typography = mybraryTypography,
      content = content,
    )
  }
}

object MybraryTheme {
  val colorScheme: ColorScheme
    @Composable
    @ReadOnlyComposable
    get() = MaterialTheme.colorScheme

  val dimens
    @Composable
    @ReadOnlyComposable
    get() = LocalDimens.current

  val shapes: Shapes
    @Composable
    @ReadOnlyComposable
    get() = MaterialTheme.shapes

  val space
    @Composable
    @ReadOnlyComposable
    get() = LocalSpace.current

  val typography: Typography
    @Composable
    @ReadOnlyComposable
    get() = MaterialTheme.typography
}
