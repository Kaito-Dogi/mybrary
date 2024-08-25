package app.kaito_dogi.mybrary.core.designsystem.component

import androidx.annotation.StringRes
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
  @StringRes textResId: Int,
) = androidx.compose.material3.TopAppBar(
  title = {
    Text(
      textResId = textResId,
    )
  },
)

@Preview
@Composable
private fun TopAppBarPreview() {
  MybraryTheme {
    TopAppBar(textResId = android.R.string.unknownName)
  }
}
