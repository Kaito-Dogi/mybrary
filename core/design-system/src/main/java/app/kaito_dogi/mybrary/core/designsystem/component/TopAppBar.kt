package app.kaito_dogi.mybrary.core.designsystem.component

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
  @StringRes textResId: Int,
  @DrawableRes navigationIconResId: Int? = null,
  @StringRes navigationIconAltResId: Int? = null,
  onNavigationIconClick: (() -> Unit)? = null,
) = androidx.compose.material3.TopAppBar(
  title = {
    Text(text = stringResource(id = textResId))
  },
  navigationIcon = {
    if (navigationIconResId != null && onNavigationIconClick != null) {
      IconButton(
        onClick = onNavigationIconClick,
      ) {
        Icon(
          iconResId = navigationIconResId,
          altResId = navigationIconAltResId,
        )
      }
    }
  },
)

@Preview
@Composable
private fun TopAppBarPreview() {
  MybraryTheme {
    TopAppBar(textResId = android.R.string.unknownName)
  }
}
