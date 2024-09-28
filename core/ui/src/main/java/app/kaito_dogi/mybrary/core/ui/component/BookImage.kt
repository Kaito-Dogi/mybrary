package app.kaito_dogi.mybrary.core.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.common.model.Url
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import coil.compose.AsyncImage

const val BookAspectRatio = 210f / 297f

@Composable
fun BookImage(
  title: String,
  imageUrl: Url.Image,
  modifier: Modifier = Modifier,
  shape: Shape = MybraryTheme.shapes.extraSmall,
) {
  Box(
    modifier = modifier
      .aspectRatio(BookAspectRatio)
      .clip(shape = shape)
      .background(MybraryTheme.colorScheme.surface),
    contentAlignment = Alignment.Center,
  ) {
    Text(
      text = title,
      modifier = Modifier
        .fillMaxWidth()
        .padding(MybraryTheme.spaces.md),
      color = MybraryTheme.colorScheme.onSurface,
      textAlign = TextAlign.Center,
      overflow = TextOverflow.Ellipsis,
      style = MybraryTheme.typography.bodySmall,
    )
    AsyncImage(
      model = imageUrl.value,
      contentDescription = title,
      modifier = Modifier.fillMaxSize(),
      contentScale = ContentScale.Crop,
    )
  }
}

@Preview
@Composable
private fun BookImagePreview() {
  MybraryTheme {
    BookImage(
      title = "title",
      imageUrl = Url.Image(value = ""),
    )
  }
}
