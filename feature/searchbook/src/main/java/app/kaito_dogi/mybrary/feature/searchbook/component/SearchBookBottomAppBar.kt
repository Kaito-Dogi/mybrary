package app.kaito_dogi.mybrary.feature.searchbook.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.ui.R

@Composable
internal fun SearchBookBottomAppBar(
  value: String,
  onValueChange: (String) -> Unit,
  onBarcodeScannerClick: () -> Unit,
  modifier: Modifier = Modifier,
) {
  BottomAppBar(
    modifier = modifier,
    contentPadding = PaddingValues(horizontal = MybraryTheme.space.md),
  ) {
    TextField(
      value = value,
      onValueChange = onValueChange,
      modifier = Modifier.weight(1f),
      placeholder = { Text(text = "検索ワードを入力…") },
      leadingIcon = {
        Icon(
          painter = painterResource(R.drawable.icon_search),
          contentDescription = "書籍一覧画面に戻る",
        )
      },
      keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
    )
    // TODO: v2 以降で実装する
//    Gap(width = MybraryTheme.space.sm)
//    FloatingActionButton(
//      onClick = onBarcodeScannerClick,
//      elevation = FloatingActionButtonDefaults.elevation(
//        defaultElevation = 0.dp,
//        pressedElevation = 0.dp,
//        focusedElevation = 0.dp,
//        hoveredElevation = 0.dp,
//      ),
//    ) {
//      Icon(
//        painter = painterResource(R.drawable.icon_barcode_scanner),
//        contentDescription = "バーコードを読み取る",
//      )
//    }
  }
}

@Preview
@Composable
private fun SearchBookBottomAppBarPreview() {
  MybraryTheme {
    SearchBookBottomAppBar(
      value = "",
      onValueChange = {},
      onBarcodeScannerClick = {},
    )
  }
}
