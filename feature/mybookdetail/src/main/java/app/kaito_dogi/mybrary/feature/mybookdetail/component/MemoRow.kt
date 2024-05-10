package app.kaito_dogi.mybrary.feature.mybookdetail.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import app.kaito_dogi.mybrary.core.designsystem.component.Gap
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.domain.model.Memo
import app.kaito_dogi.mybrary.core.domain.model.MemoId
import app.kaito_dogi.mybrary.core.domain.model.MyBookId
import java.time.LocalDateTime

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MemoRow(
  memo: Memo,
  onClick: () -> Unit,
  modifier: Modifier = Modifier,
) {
  val body = when {
    memo.fromPage != null && memo.toPage != null -> "pp.${memo.fromPage}~${memo.toPage} | ${memo.createdAt}"
    memo.fromPage != null -> "p.${memo.fromPage} | ${memo.createdAt}"
    else -> "${memo.createdAt}"
  }

  Card(
    onClick = onClick,
    modifier = modifier.fillMaxWidth(),
    shape = MybraryTheme.shapes.small,
  ) {
    Column(
      modifier = Modifier.padding(MybraryTheme.space.md),
    ) {
      Text(
        text = memo.content,
        style = MybraryTheme.typography.titleMedium,
      )
      Gap(height = MybraryTheme.space.xxs)
      Text(
        text = body,
        style = MybraryTheme.typography.bodyMedium,
      )
    }
  }
}

@Preview
@Composable
private fun MemoRowPreview(
  @PreviewParameter(PreviewMemoProvider::class) memo: Memo,
) {
  MybraryTheme {
    MemoRow(
      memo = memo,
      onClick = {},
    )
  }
}

private class PreviewMemoProvider : PreviewParameterProvider<Memo> {
  override val values: Sequence<Memo>
    get() = sequenceOf(
      // 開始ページ・終了ページが記録されている場合
      Memo(
        id = MemoId(0),
        myBookId = MyBookId(0),
        content = "Memo",
        fromPage = 1,
        toPage = 100,
        createdAt = LocalDateTime.now(),
        isPosted = false,
        postedAt = null,
        likeCount = null,
      ),
      // 開始ページのみが記録されている場合
      Memo(
        id = MemoId(0),
        myBookId = MyBookId(0),
        content = "Memo",
        fromPage = 50,
        toPage = null,
        createdAt = LocalDateTime.now(),
        isPosted = false,
        postedAt = null,
        likeCount = null,
      ),
      // ページが記録されていない場合
      Memo(
        id = MemoId(0),
        myBookId = MyBookId(0),
        content = "Memo",
        fromPage = null,
        toPage = null,
        createdAt = LocalDateTime.now(),
        isPosted = false,
        postedAt = null,
        likeCount = null,
      ),
    )
}
