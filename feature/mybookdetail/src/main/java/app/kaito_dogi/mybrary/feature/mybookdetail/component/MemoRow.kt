package app.kaito_dogi.mybrary.feature.mybookdetail.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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

@Composable
internal fun MemoRow(
  memo: Memo,
  onClick: (Memo) -> Unit,
  modifier: Modifier = Modifier,
) {
  Card(
    onClick = { onClick(memo) },
    modifier = modifier,
    shape = MybraryTheme.shapes.small,
  ) {
    // top の padding を小さくすることで、錯視を調整
    Column(
      modifier = Modifier.padding(
        start = MybraryTheme.space.md,
        top = MybraryTheme.space.sm,
        end = MybraryTheme.space.md,
        bottom = MybraryTheme.space.md,
      ),
    ) {
      Text(
        text = memo.content,
        modifier = Modifier.fillMaxWidth(),
        style = MybraryTheme.typography.bodyLarge,
      )
      Gap(height = MybraryTheme.space.xxs)
      Text(
        text = memo.cardBody,
        modifier = Modifier.fillMaxWidth(),
        // TODO: カラースキーマを整理する
        color = Color.Gray,
        style = MybraryTheme.typography.bodySmall,
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
      this.updatedAt != null -> "${this.updatedAt?.toFormattedString()}（編集済み）"
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
          name = "ユーザー名",
        ),
        content = "メモ",
        fromPage = 1,
        toPage = 100,
        createdAt = LocalDateTime.now(),
        updatedAt = null,
        publishedAt = null,
        likeCount = null,
      ),
      // 片方のページのみが記録されている場合
      Memo(
        id = MemoId(value = 0),
        myBookId = MyBookId(value = 0),
        user = User(
          id = UserId(value = 0L),
          name = "ユーザー名",
        ),
        content = "メモ",
        fromPage = 50,
        toPage = null,
        createdAt = LocalDateTime.now(),
        updatedAt = null,
        publishedAt = null,
        likeCount = null,
      ),
      // ページが記録されていない場合
      Memo(
        id = MemoId(value = 0),
        myBookId = MyBookId(value = 0),
        user = User(
          id = UserId(value = 0L),
          name = "ユーザー名",
        ),
        content = "メモ",
        fromPage = null,
        toPage = null,
        createdAt = LocalDateTime.now(),
        updatedAt = null,
        publishedAt = null,
        likeCount = null,
      ),
      // 編集済みの場合
      Memo(
        id = MemoId(value = 0),
        myBookId = MyBookId(value = 0),
        user = User(
          id = UserId(value = 0L),
          name = "ユーザー名",
        ),
        content = "メモ",
        fromPage = 1,
        toPage = 100,
        createdAt = LocalDateTime.now(),
        updatedAt = LocalDateTime.now(),
        publishedAt = null,
        likeCount = null,
      ),
      // 複数行の場合
      Memo(
        id = MemoId(value = 0),
        myBookId = MyBookId(value = 0),
        user = User(
          id = UserId(value = 0L),
          name = "ユーザー名",
        ),
        content = "日本人はものをうまく作ることに取り憑かれている米国人はとにかく仕事を終えることを考える。",
        fromPage = 1,
        toPage = 100,
        createdAt = LocalDateTime.now(),
        updatedAt = null,
        publishedAt = null,
        likeCount = null,
      ),
    )
}
