package app.kaito_dogi.mybrary.feature.login.component

import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme

@Composable
internal fun SignUpSection(
  onClick: () -> Unit,
  modifier: Modifier = Modifier,
) {
  val annotatedString = buildAnnotatedString {
    withStyle(
      style = SpanStyle(
        color = MybraryTheme.colorScheme.onBackground,
      ),
    ) {
      append("アカウント作成は")
    }
    withStyle(
      style = SpanStyle(
        textDecoration = TextDecoration.Underline,
      ),
    ) {
      append("こちら")
    }
  }

  TextButton(
    onClick = { onClick() },
    modifier = modifier,
  ) {
    Text(text = annotatedString)
  }
}

@Preview
@Composable
private fun SignUpSectionPreview() {
  MybraryTheme {
    SignUpSection(onClick = {})
  }
}
