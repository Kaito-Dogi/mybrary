package app.kaito_dogi.mybrary.core.ui.component.auth

import androidx.compose.material3.MaterialTheme
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
import app.kaito_dogi.mybrary.core.common.model.Url
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.ui.R
import app.kaito_dogi.mybrary.core.ui.config.rememberAppConfig

@Composable
fun TermsOfUsePrivacyPolicyText(
  launchInternalBrowser: (Url.Web) -> Unit,
  modifier: Modifier = Modifier,
) {
  val context = LocalContext.current
  val appConfig = rememberAppConfig()

  val textStyle = SpanStyle(
    color = MaterialTheme.colorScheme.outline,
  )
  val linkStyle = TextLinkStyles(
    style = SpanStyle(
      color = MaterialTheme.colorScheme.primary,
      textDecoration = TextDecoration.Underline,
    ),
  )

  val annotatedString = buildAnnotatedString {
    withLink(
      LinkAnnotation.Clickable(
        tag = context.getString(R.string.ui_text_terms_of_use),
        styles = linkStyle,
        linkInteractionListener = { launchInternalBrowser(appConfig.termsOfUseUrl) },
      ),
    ) {
      append(context.getString(R.string.ui_text_terms_of_use))
    }

    withStyle(style = textStyle) {
      append(context.getString(R.string.ui_text_and))
    }

    withLink(
      LinkAnnotation.Clickable(
        tag = context.getString(R.string.ui_text_privacy_policy),
        styles = linkStyle,
        linkInteractionListener = { launchInternalBrowser(appConfig.privacyPolicyUrl) },
      ),
    ) {
      append(context.getString(R.string.ui_text_privacy_policy))
    }

    withStyle(style = textStyle) {
      append(context.getString(R.string.ui_text_apply))
    }
  }

  Text(
    text = annotatedString,
    modifier = modifier,
    textAlign = TextAlign.Center,
    style = MaterialTheme.typography.labelLarge,
  )
}

@Preview
@Composable
private fun TermsOfUsePrivacyPolicyTextPreview() {
  MybraryTheme {
    TermsOfUsePrivacyPolicyText(
      launchInternalBrowser = {},
    )
  }
}
