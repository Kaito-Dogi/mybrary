package app.kaito_dogi.mybrary.core.designsystem.component

import androidx.annotation.StringRes
import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun Text(
  @StringRes textResId: Int,
  modifier: Modifier = Modifier,
  color: Color = Color.Unspecified,
  textAlign: TextAlign? = null,
  overflow: TextOverflow = TextOverflow.Clip,
  softWrap: Boolean = true,
  maxLines: Int = Int.MAX_VALUE,
  minLines: Int = 1,
  style: TextStyle = LocalTextStyle.current,
) = androidx.compose.material3.Text(
  text = stringResource(id = textResId),
  modifier = modifier,
  color = color,
  textAlign = textAlign,
  overflow = overflow,
  softWrap = softWrap,
  maxLines = maxLines,
  minLines = minLines,
  style = style,
)
