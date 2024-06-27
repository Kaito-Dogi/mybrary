package app.kaito_dogi.mybrary.feature.mybooklist.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme

@Composable
internal fun MyBookListHeader(
  title: String,
  modifier: Modifier = Modifier,
) {
  Text(
    text = title,
    modifier = modifier.fillMaxWidth(),
    color = MybraryTheme.colorScheme.onBackground,
    style = MybraryTheme.typography.headlineMedium,
  )
}

@Preview(showBackground = true)
@Composable
private fun MyBookListHeaderPreview() {
  MybraryTheme {
    MyBookListHeader(title = "タイトル")
  }
}
