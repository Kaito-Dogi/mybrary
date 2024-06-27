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
import app.kaito_dogi.mybrary.core.ui.R

@Composable
internal fun MyBookDetailBottomAppBar(
  isPublic: Boolean,
  isFavorite: Boolean,
  onArchiveClick: () -> Unit,
  onPublicClick: () -> Unit,
  onFavoriteClick: () -> Unit,
  onAdditionClick: () -> Unit,
  modifier: Modifier = Modifier,
) {
  BottomAppBar(
    modifier = modifier,
    contentPadding = PaddingValues(
      start = MybraryTheme.space.xxs,
      end = MybraryTheme.space.md,
    ),
  ) {
    // TODO: v2 以降で実装を復活させる
//    IconButton(onClick = onArchiveClick) {
//      Icon(
//        painter = painterResource(R.drawable.icon_archive),
//        contentDescription = "書籍を非表示にする",
//      )
//    }
//    IconButton(onClick = onPublicClick) {
//      Icon(
//        painter = if (isPublic) {
//          painterResource(R.drawable.icon_visibility)
//        } else {
//          painterResource(R.drawable.icon_visibility_off)
//        },
//        contentDescription = "書籍を他のユーザーに公開する",
//      )
//    }
    IconButton(onClick = onFavoriteClick) {
      Icon(
        painter = if (isFavorite) {
          painterResource(R.drawable.icon_heart_filled)
        } else {
          painterResource(R.drawable.icon_heart_outlined)
        },
        contentDescription = "書籍をお気に入り登録する",
      )
    }
    Spacer(modifier = Modifier.weight(1f))
    FloatingActionButton(
      onClick = onAdditionClick,
      elevation = FloatingActionButtonDefaults.elevation(
        defaultElevation = 0.dp,
        pressedElevation = 0.dp,
        focusedElevation = 0.dp,
        hoveredElevation = 0.dp,
      ),
    ) {
      Icon(
        painter = painterResource(R.drawable.icon_add),
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
      isPublic = false,
      onArchiveClick = {},
      onFavoriteClick = {},
      onPublicClick = {},
      onAdditionClick = {},
    )
  }
}
