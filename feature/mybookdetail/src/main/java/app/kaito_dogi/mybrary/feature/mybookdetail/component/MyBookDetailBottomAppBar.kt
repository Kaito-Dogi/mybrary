package app.kaito_dogi.mybrary.feature.mybookdetail.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme

@Composable
internal fun MyBookDetailBottomAppBar(
  onBackClick: () -> Unit,
  onArchiveClick: () -> Unit,
  onFavoriteClick: () -> Unit,
  onEditClick: () -> Unit,
  modifier: Modifier = Modifier,
) {
  BottomAppBar(
    modifier = modifier.fillMaxWidth(),
    contentPadding = PaddingValues(
      start = MybraryTheme.space.xxs,
      end = MybraryTheme.space.md,
    ),
  ) {
    IconButton(onClick = onBackClick) {
      Icon(
        imageVector = Icons.Default.Add,
        contentDescription = "書籍一覧画面に戻る",
      )
    }
    IconButton(onClick = onArchiveClick) {
      Icon(
        // TODO: archive アイコンに差し替える
        imageVector = Icons.Default.Delete,
        contentDescription = "書籍を非表示にする",
      )
    }
    IconButton(onClick = onFavoriteClick) {
      Icon(
        imageVector = Icons.Default.Favorite,
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
        imageVector = Icons.Default.Edit,
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
      onBackClick = {},
      onArchiveClick = {},
      onFavoriteClick = {},
      onEditClick = {},
    )
  }
}
