package app.kaito_dogi.mybrary.feature.mybookdetail.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.feature.mybookdetail.R

@Composable
internal fun MyBookDetailBottomAppBar(
  isFavorite: Boolean,
  onBackClick: () -> Unit,
  onArchiveClick: () -> Unit,
  onFavoriteClick: () -> Unit,
  onEditClick: () -> Unit,
  modifier: Modifier = Modifier,
) {
  BottomAppBar(
    modifier = modifier,
    contentPadding = PaddingValues(
      start = MybraryTheme.space.xxs,
      end = MybraryTheme.space.md,
    ),
  ) {
    IconButton(onClick = onBackClick) {
      Icon(
        painter = painterResource(id = R.drawable.mybookdetail_arrow_back),
        contentDescription = "書籍一覧画面に戻る",
      )
    }
    IconButton(onClick = onArchiveClick) {
      Icon(
        painter = painterResource(id = R.drawable.mybookdetail_archive),
        contentDescription = "書籍を非表示にする",
      )
    }
    IconButton(onClick = onFavoriteClick) {
      Icon(
        painter = if (isFavorite) {
          painterResource(id = R.drawable.mybookdetail_heart_filled)
        } else painterResource(
          id = R.drawable.mybookdetail_heart_outlined,
        ),
        contentDescription = "書籍をお気に入り登録する",
      )
    }
    Spacer(modifier = Modifier.weight(1f))
    FloatingActionButton(
      onClick = onEditClick,
      elevation = FloatingActionButtonDefaults.elevation(
        defaultElevation = 0.dp,
        pressedElevation = 0.dp,
        focusedElevation = 0.dp,
        hoveredElevation = 0.dp,
      ),
    ) {
      Icon(
        painter = painterResource(id = R.drawable.mybookdetail_edit),
        contentDescription = "メモを編集",
      )
    }
  }
}

@Preview
@Composable
private fun MyBookDetailBottomAppBarPreview() {
  MybraryTheme {
    MyBookDetailBottomAppBar(
      isFavorite = false,
      onBackClick = {},
      onArchiveClick = {},
      onFavoriteClick = {},
      onEditClick = {},
    )
  }
}
