package app.kaito_dogi.mybrary.feature.signup.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.ui.R

@Composable
internal fun NavigateToSignInSection(
  onClick: () -> Unit,
  modifier: Modifier = Modifier,
) {
  val context = LocalContext.current

  val annotatedString = buildAnnotatedString {
    withStyle(
      style = SpanStyle(
        color = MybraryTheme.colorScheme.outline,
      ),
    ) {
      append(context.getString(R.string.send_otp_text_already_have_an_account_login))
    }

    withLink(
      LinkAnnotation.Clickable(
        tag = context.getString(R.string.send_otp_text_here),
        styles = TextLinkStyles(
          style = SpanStyle(
            color = MybraryTheme.colorScheme.primary,
            textDecoration = TextDecoration.Underline,
          ),
        ),
        linkInteractionListener = { onClick() },
      ),
    ) {
      append(context.getString(R.string.send_otp_text_here))
    }
  }

  Text(
    text = annotatedString,
    modifier = modifier,
    textAlign = TextAlign.Center,
    style = MybraryTheme.typography.labelLarge,
  )
}

@Preview(showBackground = true)
@Composable
private fun NavigateToSignInSectionPreview() {
  MybraryTheme {
    NavigateToSignInSection(onClick = {})
  }
}
