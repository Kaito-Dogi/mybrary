package app.kaito_dogi.mybrary.core.designsystem.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

private val primaryLight = Color(color = 0xFF266A4A)
private val onPrimaryLight = Color(color = 0xFFFFFFFF)
private val primaryContainerLight = Color(color = 0xFFACF2C8)
private val onPrimaryContainerLight = Color(color = 0xFF002112)
private val secondaryLight = Color(color = 0xFF34693F)
private val onSecondaryLight = Color(color = 0xFFFFFFFF)
private val secondaryContainerLight = Color(color = 0xFFB6F1BC)
private val onSecondaryContainerLight = Color(color = 0xFF00210A)
private val tertiaryLight = Color(color = 0xFF8E4954)
private val onTertiaryLight = Color(color = 0xFFFFFFFF)
private val tertiaryContainerLight = Color(color = 0xFFFFD9DD)
private val onTertiaryContainerLight = Color(color = 0xFF3B0714)
private val errorLight = Color(color = 0xFF8F4A50)
private val onErrorLight = Color(color = 0xFFFFFFFF)
private val errorContainerLight = Color(color = 0xFFFFDADB)
private val onErrorContainerLight = Color(color = 0xFF3B0810)
private val backgroundLight = Color(color = 0xFFF6FBF4)
private val onBackgroundLight = Color(color = 0xFF171D19)
private val surfaceLight = Color(color = 0xFFF6FBF4)
private val onSurfaceLight = Color(color = 0xFF171D19)
private val surfaceVariantLight = Color(color = 0xFFDCE5DC)
private val onSurfaceVariantLight = Color(color = 0xFF404943)
private val outlineLight = Color(color = 0xFF707972)
private val outlineVariantLight = Color(color = 0xFFC0C9C1)
private val scrimLight = Color(color = 0xFF000000)
private val inverseSurfaceLight = Color(color = 0xFF2C322E)
private val inverseOnSurfaceLight = Color(color = 0xFFEDF2EC)
private val inversePrimaryLight = Color(color = 0xFF91D5AD)
private val surfaceDimLight = Color(color = 0xFFD6DBD5)
private val surfaceBrightLight = Color(color = 0xFFF6FBF4)
private val surfaceContainerLowestLight = Color(color = 0xFFFFFFFF)
private val surfaceContainerLowLight = Color(color = 0xFFF0F5EE)
private val surfaceContainerLight = Color(color = 0xFFEAEFE9)
private val surfaceContainerHighLight = Color(color = 0xFFE4EAE3)
private val surfaceContainerHighestLight = Color(color = 0xFFDFE4DD)

private val primaryDark = Color(color = 0xFF91D5AD)
private val onPrimaryDark = Color(color = 0xFF003822)
private val primaryContainerDark = Color(color = 0xFF025233)
private val onPrimaryContainerDark = Color(color = 0xFFACF2C8)
private val secondaryDark = Color(color = 0xFF9AD4A1)
private val onSecondaryDark = Color(color = 0xFF003916)
private val secondaryContainerDark = Color(color = 0xFF1A512A)
private val onSecondaryContainerDark = Color(color = 0xFFB6F1BC)
private val tertiaryDark = Color(color = 0xFFFFB2BB)
private val onTertiaryDark = Color(color = 0xFF561D28)
private val tertiaryContainerDark = Color(color = 0xFF72333D)
private val onTertiaryContainerDark = Color(color = 0xFFFFD9DD)
private val errorDark = Color(color = 0xFFFFB2B7)
private val onErrorDark = Color(color = 0xFF561D24)
private val errorContainerDark = Color(color = 0xFF723339)
private val onErrorContainerDark = Color(color = 0xFFFFDADB)
private val backgroundDark = Color(color = 0xFF0F1511)
private val onBackgroundDark = Color(color = 0xFFDFE4DD)
private val surfaceDark = Color(color = 0xFF0F1511)
private val onSurfaceDark = Color(color = 0xFFDFE4DD)
private val surfaceVariantDark = Color(color = 0xFF404943)
private val onSurfaceVariantDark = Color(color = 0xFFC0C9C1)
private val outlineDark = Color(color = 0xFF8A938B)
private val outlineVariantDark = Color(color = 0xFF404943)
private val scrimDark = Color(color = 0xFF000000)
private val inverseSurfaceDark = Color(color = 0xFFDFE4DD)
private val inverseOnSurfaceDark = Color(color = 0xFF2C322E)
private val inversePrimaryDark = Color(color = 0xFF266A4A)
private val surfaceDimDark = Color(color = 0xFF0F1511)
private val surfaceBrightDark = Color(color = 0xFF353B36)
private val surfaceContainerLowestDark = Color(color = 0xFF0A0F0C)
private val surfaceContainerLowDark = Color(color = 0xFF171D19)
private val surfaceContainerDark = Color(color = 0xFF1B211D)
private val surfaceContainerHighDark = Color(color = 0xFF262B27)
private val surfaceContainerHighestDark = Color(color = 0xFF303632)

val mybraryLightColorScheme = lightColorScheme(
  primary = primaryLight,
  onPrimary = onPrimaryLight,
  primaryContainer = primaryContainerLight,
  onPrimaryContainer = onPrimaryContainerLight,
  inversePrimary = inversePrimaryLight,
  secondary = secondaryLight,
  onSecondary = onSecondaryLight,
  secondaryContainer = secondaryContainerLight,
  onSecondaryContainer = onSecondaryContainerLight,
  tertiary = tertiaryLight,
  onTertiary = onTertiaryLight,
  tertiaryContainer = tertiaryContainerLight,
  onTertiaryContainer = onTertiaryContainerLight,
  background = backgroundLight,
  onBackground = onBackgroundLight,
  surface = surfaceLight,
  onSurface = onSurfaceLight,
  surfaceVariant = surfaceVariantLight,
  onSurfaceVariant = onSurfaceVariantLight,
  surfaceTint = inversePrimaryLight,
  inverseOnSurface = inverseOnSurfaceLight,
  inverseSurface = inverseSurfaceLight,
  error = errorLight,
  onError = onErrorLight,
  errorContainer = errorContainerLight,
  onErrorContainer = onErrorContainerLight,
  outline = outlineLight,
  outlineVariant = outlineVariantLight,
  scrim = scrimLight,
  surfaceBright = surfaceBrightLight,
  surfaceContainer = surfaceContainerLight,
  surfaceContainerHigh = surfaceContainerHighLight,
  surfaceContainerHighest = surfaceContainerHighestLight,
  surfaceContainerLow = surfaceContainerLowLight,
  surfaceContainerLowest = surfaceContainerLowestLight,
  surfaceDim = surfaceDimLight,
)

val mybraryDarkColorScheme = darkColorScheme(
  primary = primaryDark,
  onPrimary = onPrimaryDark,
  primaryContainer = primaryContainerDark,
  onPrimaryContainer = onPrimaryContainerDark,
  inversePrimary = inversePrimaryDark,
  secondary = secondaryDark,
  onSecondary = onSecondaryDark,
  secondaryContainer = secondaryContainerDark,
  onSecondaryContainer = onSecondaryContainerDark,
  tertiary = tertiaryDark,
  onTertiary = onTertiaryDark,
  tertiaryContainer = tertiaryContainerDark,
  onTertiaryContainer = onTertiaryContainerDark,
  background = backgroundDark,
  onBackground = onBackgroundDark,
  surface = surfaceDark,
  onSurface = onSurfaceDark,
  surfaceVariant = surfaceVariantDark,
  onSurfaceVariant = onSurfaceVariantDark,
  surfaceTint = inversePrimaryDark,
  inverseOnSurface = inverseOnSurfaceDark,
  inverseSurface = inverseSurfaceDark,
  error = errorDark,
  onError = onErrorDark,
  errorContainer = errorContainerDark,
  onErrorContainer = onErrorContainerDark,
  outline = outlineDark,
  outlineVariant = outlineVariantDark,
  scrim = scrimDark,
  surfaceBright = surfaceBrightDark,
  surfaceContainer = surfaceContainerDark,
  surfaceContainerHigh = surfaceContainerHighDark,
  surfaceContainerHighest = surfaceContainerHighestDark,
  surfaceContainerLow = surfaceContainerLowDark,
  surfaceContainerLowest = surfaceContainerLowestDark,
  surfaceDim = surfaceDimDark,
)
