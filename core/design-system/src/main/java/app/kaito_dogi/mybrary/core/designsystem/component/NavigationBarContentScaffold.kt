package app.kaito_dogi.mybrary.core.designsystem.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.add
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

private val NavigationBarHeight = 80.dp

@Composable
fun NavigationBarContentScaffold(
  modifier: Modifier = Modifier,
  topBar: @Composable () -> Unit = {},
  bottomBar: @Composable () -> Unit = {},
  snackbarHost: @Composable () -> Unit = {},
  floatingActionButton: @Composable () -> Unit = {},
  floatingActionButtonPosition: FabPosition = FabPosition.End,
  containerColor: Color = MaterialTheme.colorScheme.background,
  contentColor: Color = contentColorFor(containerColor),
  contentWindowInsets: WindowInsets = ScaffoldDefaults.contentWindowInsets.add(WindowInsets(bottom = NavigationBarHeight)),
  content: @Composable (PaddingValues) -> Unit,
) = Scaffold(
  modifier = modifier,
  topBar = topBar,
  bottomBar = bottomBar,
  snackbarHost = snackbarHost,
  floatingActionButton = floatingActionButton,
  floatingActionButtonPosition = floatingActionButtonPosition,
  contentColor = contentColor,
  contentWindowInsets = contentWindowInsets,
  content = content,
)
