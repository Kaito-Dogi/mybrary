package app.kaito_dogi.mybrary.feature.mybook.destination.mybookdetail.component

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.ext.elevationZero
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
      start = MybraryTheme.spaces.xxs,
      end = MybraryTheme.spaces.md,
    ),
  ) {
    // TODO: v2 以降で実装を復活させる
//    IconButton(onClick = onArchiveClick) {
//      Icon(
//        iconResId = R.drawable.icon_archive,
//        altResId = R.string.my_book_detail_desc_archive_my_book,
//      )
//    }
//
//    IconButton(onClick = onPublicClick) {
//      Icon(
//        iconResId = if (isPublic) R.drawable.icon_visibility else R.drawable.icon_visibility_off,
//        altResId = if (isPublic) R.string.my_book_detail_desc_make_my_book_private else R.string.my_book_detail_desc_make_my_book_public,
//      )
//    }

    IconButton(onClick = onFavoriteClick) {
      Icon(
        painter = if (isFavorite) {
          painterResource(R.drawable.icon_heart_filled)
        } else {
          painterResource(R.drawable.icon_heart_outlined)
        },
        contentDescription = if (isFavorite) {
          stringResource(R.string.my_book_detail_alt_remove_my_book_from_favorites)
        } else {
          stringResource(R.string.my_book_detail_alt_add_my_book_to_favorites)
        },
      )
    }

    Spacer(modifier = Modifier.weight(1f))

    FloatingActionButton(
      onClick = onAdditionClick,
      elevation = FloatingActionButtonDefaults.elevationZero(),
    ) {
      Icon(
        painter = painterResource(R.drawable.icon_add),
        contentDescription = stringResource(R.string.my_book_detail_alt_create_a_memo),
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
