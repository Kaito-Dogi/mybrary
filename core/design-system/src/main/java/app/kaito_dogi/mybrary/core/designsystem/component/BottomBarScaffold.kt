package app.kaito_dogi.mybrary.core.designsystem.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun BottomBarScaffold(
  modifier: Modifier = Modifier,
  bottomBar: @Composable () -> Unit = {},
  snackbarHost: @Composable () -> Unit = {},
  content: @Composable (PaddingValues) -> Unit,
) = Scaffold(
  modifier = modifier,
  bottomBar = bottomBar,
  snackbarHost = snackbarHost,
  contentWindowInsets = WindowInsets.navigationBars,
  content = content,
)
