package app.kaito_dogi.mybrary.core.designsystem.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Scaffold(
  modifier: Modifier = Modifier,
  topBar: @Composable () -> Unit = {},
  content: @Composable (PaddingValues) -> Unit,
) = androidx.compose.material3.Scaffold(
  modifier = modifier,
  topBar = topBar,
  content = content,
)
