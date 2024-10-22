package app.kaito_dogi.mybrary.core.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.ui.R

@Composable
fun OrDivider(
  modifier: Modifier = Modifier,
) {
  Row(
    modifier = modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.spacedBy(MybraryTheme.spaces.xs),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    HorizontalDivider(
      modifier = Modifier.weight(1f),
      color = MybraryTheme.colorScheme.outline,
    )

    Text(
      text = stringResource(id = R.string.ui_text_or),
      color = MybraryTheme.colorScheme.outline,
      style = MybraryTheme.typography.labelMedium,
    )

    HorizontalDivider(
      modifier = Modifier.weight(1f),
      color = MybraryTheme.colorScheme.outline,
    )
  }
}

@Preview
@Composable
private fun OrDividerPreview() {
  MybraryTheme {
    OrDivider()
  }
}
