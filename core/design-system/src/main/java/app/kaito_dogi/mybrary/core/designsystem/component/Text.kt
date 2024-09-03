package app.kaito_dogi.mybrary.core.designsystem.component

import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun Text(
  text: String,
  modifier: Modifier = Modifier,
  color: Color = Color.Unspecified,
  textAlign: TextAlign? = null,
  overflow: TextOverflow = TextOverflow.Clip,
  softWrap: Boolean = true,
  maxLines: Int = Int.MAX_VALUE,
  minLines: Int = 1,
  style: TextStyle = LocalTextStyle.current,
) = androidx.compose.material3.Text(
  text = text,
  modifier = modifier,
  color = color,
  textAlign = textAlign,
  overflow = overflow,
  softWrap = softWrap,
  maxLines = maxLines,
  minLines = minLines,
  style = style,
)
