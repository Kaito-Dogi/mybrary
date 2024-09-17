package app.kaito_dogi.mybrary.feature.auth.destination.sendotp.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.ui.navigation.route.AuthRoute

private val DotSize = 6.dp

@Composable
internal fun HorizontalPagerIndicator(
  currentPage: Int,
  modifier: Modifier = Modifier,
) {
  Row(
    modifier = modifier,
    horizontalArrangement = Arrangement.spacedBy(
      space = MybraryTheme.spaces.xxs,
      alignment = Alignment.CenterHorizontally,
    ),
  ) {
    AuthRoute.VerifyOtp.Page.entries.forEach {
      Box(
        modifier = Modifier
          .size(DotSize)
          .clip(CircleShape)
          .background(
            if (it.ordinal == currentPage) MybraryTheme.colorScheme.primary
            else MybraryTheme.colorScheme.outline,
          ),
      )
    }
  }
}

@Preview(showBackground = true)
@Composable
private fun HorizontalPagerIndicatorPreview() {
  MybraryTheme {
    HorizontalPagerIndicator(
      currentPage = 0,
    )
  }
}
