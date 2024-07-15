package app.kaito_dogi.mybrary.core.ui.component

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.common.model.Url
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.ui.R
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter

const val BookAspectRatio = 210f / 297f

@Composable
fun BookImage(
  imageUrl: Url.Image?,
  modifier: Modifier = Modifier,
  shape: Shape = MybraryTheme.shapes.extraSmall,
  onLoading: ((AsyncImagePainter.State.Loading) -> Unit)? = null,
  onSuccess: ((AsyncImagePainter.State.Success) -> Unit)? = null,
  onError: ((AsyncImagePainter.State.Error) -> Unit)? = null,
  alignment: Alignment = Alignment.Center,
  alpha: Float = DefaultAlpha,
  colorFilter: ColorFilter? = null,
  filterQuality: FilterQuality = DrawScope.DefaultFilterQuality,
) {
  AsyncImage(
    model = imageUrl?.value,
    contentDescription = stringResource(id = R.string.ui_desc_book_cover),
    modifier = modifier
      .clip(shape = shape)
      .aspectRatio(BookAspectRatio),
    placeholder = painterResource(R.drawable.img_book_placeholder),
    error = painterResource(R.drawable.img_book_placeholder),
    onLoading = onLoading,
    onSuccess = onSuccess,
    onError = onError,
    alignment = alignment,
    contentScale = ContentScale.Crop,
    alpha = alpha,
    colorFilter = colorFilter,
    filterQuality = filterQuality,
  )
}

@Preview
@Composable
private fun BookImagePreview() {
  MybraryTheme {
    BookImage(
      imageUrl = null,
    )
  }
}
