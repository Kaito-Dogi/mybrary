package app.kaito_dogi.mybrary.feature.mybookdetail.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.component.Icon
import app.kaito_dogi.mybrary.core.designsystem.extension.elevationZero
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
//        iconResId = R.drawable.icon_archive,
//        descResId = R.string.my_book_detail_desc_archive_my_book,
//      )
//    }
//
//    IconButton(onClick = onPublicClick) {
//      Icon(
//        iconResId = if (isPublic) R.drawable.icon_visibility else R.drawable.icon_visibility_off,
//        descResId = if (isPublic) R.string.my_book_detail_desc_make_my_book_private else R.string.my_book_detail_desc_make_my_book_public,
//      )
//    }

    IconButton(onClick = onFavoriteClick) {
      Icon(
        iconResId = if (isFavorite) R.drawable.icon_heart_filled else R.drawable.icon_heart_outlined,
        descResId = if (isFavorite) R.string.my_book_detail_desc_remove_my_book_from_favorites else R.string.my_book_detail_desc_add_my_book_to_favorites,
      )
    }

    Spacer(modifier = Modifier.weight(1f))

    FloatingActionButton(
      onClick = onAdditionClick,
      elevation = FloatingActionButtonDefaults.elevationZero(),
    ) {
      Icon(
        iconResId = R.drawable.icon_add,
        descResId = R.string.my_book_detail_desc_create_a_memo,
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
