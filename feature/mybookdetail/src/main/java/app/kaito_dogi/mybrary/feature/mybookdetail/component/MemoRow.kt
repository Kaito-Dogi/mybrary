package app.kaito_dogi.mybrary.feature.mybookdetail.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import app.kaito_dogi.mybrary.core.designsystem.component.Gap
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.domain.model.Memo
import app.kaito_dogi.mybrary.core.domain.model.MemoId
import app.kaito_dogi.mybrary.core.domain.model.MyBookId
import app.kaito_dogi.mybrary.core.domain.model.User
import app.kaito_dogi.mybrary.core.domain.model.UserId
import app.kaito_dogi.mybrary.core.ui.datetime.toFormattedString
import java.time.LocalDateTime

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MemoRow(
  memo: Memo,
  onClick: (Memo) -> Unit,
  modifier: Modifier = Modifier,
) {
  val body = remember(memo) { memo.cardBody }

  Card(
    onClick = { onClick(memo) },
    modifier = modifier.fillMaxWidth(),
    shape = MybraryTheme.shapes.small,
  ) {
    // top の padding を小さくすることで、錯視を調整
    Column(
      modifier = Modifier
        .padding(
          start = MybraryTheme.space.md,
          top = MybraryTheme.space.sm,
          end = MybraryTheme.space.md,
          bottom = MybraryTheme.space.md,
        )
        .fillMaxWidth(),
    ) {
      Text(
        text = memo.content,
        modifier = Modifier.fillMaxWidth(),
        style = MybraryTheme.typography.titleMedium,
      )
      Gap(height = MybraryTheme.space.xxs)
      Text(
        text = body,
        modifier = Modifier.fillMaxWidth(),
        style = MybraryTheme.typography.bodyMedium,
      )
    }
  }
}

private val Memo.cardBody
  get() = run {
    val page = when {
      this.fromPage != null && this.toPage != null -> "pp.${this.fromPage}~${this.toPage}"
      this.fromPage != null || this.toPage != null -> "p.${this.fromPage}"
      else -> ""
    }
    val datetime = when {
      this.editedAt != null -> "${this.editedAt?.toFormattedString()}（編集済み）"
      else -> this.createdAt.toFormattedString()
    }
    if (page.isNotBlank()) "$page｜$datetime" else datetime
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
        id = MemoId(value = 0),
        myBookId = MyBookId(value = 0),
        user = User(
          id = UserId(value = 0L),
          name = "name",
        ),
        content = "content",
        fromPage = 1,
        toPage = 100,
        createdAt = LocalDateTime.now(),
        editedAt = null,
        postedAt = null,
        likeCount = null,
      ),
      // 開始ページのみが記録されている場合
      Memo(
        id = MemoId(value = 0),
        myBookId = MyBookId(value = 0),
        user = User(
          id = UserId(value = 0L),
          name = "name",
        ),
        content = "content",
        fromPage = 50,
        toPage = null,
        createdAt = LocalDateTime.now(),
        editedAt = null,
        postedAt = null,
        likeCount = null,
      ),
      // ページが記録されていない場合
      Memo(
        id = MemoId(value = 0),
        myBookId = MyBookId(value = 0),
        user = User(
          id = UserId(value = 0L),
          name = "name",
        ),
        content = "content",
        fromPage = null,
        toPage = null,
        createdAt = LocalDateTime.now(),
        editedAt = null,
        postedAt = null,
        likeCount = null,
      ),
    )
}
