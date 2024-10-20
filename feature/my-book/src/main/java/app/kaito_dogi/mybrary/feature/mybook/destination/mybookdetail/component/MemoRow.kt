package app.kaito_dogi.mybrary.feature.mybook.destination.mybookdetail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.domain.model.Memo
import app.kaito_dogi.mybrary.core.domain.model.MemoId
import app.kaito_dogi.mybrary.core.domain.model.PageRange
import app.kaito_dogi.mybrary.core.ui.R
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
    shape = MybraryTheme.shapes.cornerMd,
  ) {
    // top の padding を小さくすることで、錯視を調整
    Column(
      modifier = Modifier.padding(
        start = MybraryTheme.spaces.sm,
        top = MybraryTheme.spaces.xs,
        end = MybraryTheme.spaces.sm,
        bottom = MybraryTheme.spaces.sm,
      ),
      verticalArrangement = Arrangement.spacedBy(MybraryTheme.spaces.xxs),
    ) {
      Text(
        text = memo.content,
        modifier = Modifier.fillMaxWidth(),
        style = MybraryTheme.typography.bodyLarge,
      )

      val context = LocalContext.current
      val rowBody = remember(memo, context) {
        val page = when {
          memo.pageRange?.end != null -> context.getString(
            R.string.my_book_detail_text_pp,
            memo.pageRange?.start,
            memo.pageRange?.end,
          )

          memo.pageRange?.start != null -> context.getString(
            R.string.my_book_detail_text_p,
            memo.pageRange?.start,
          )

          else -> ""
        }

        val datetimeText = when {
          memo.editedAt != null -> context.getString(
            R.string.my_book_detail_text_edited,
            memo.editedAt?.toFormattedString(),
          )

          else -> memo.createdAt.toFormattedString()
        }

        if (page.isNotBlank()) "$page｜$datetimeText" else datetimeText
      }
      Text(
        text = rowBody,
        modifier = Modifier.fillMaxWidth(),
        color = MybraryTheme.colorScheme.onSurfaceVariant,
        style = MybraryTheme.typography.bodySmall,
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
        id = MemoId(value = ""),
        content = "メモ",
        pageRange = PageRange(
          start = 0,
          end = Int.MAX_VALUE,
        ),
        createdAt = LocalDateTime.now(),
        editedAt = null,
        publishedAt = null,
        likeCount = 0,
      ),
      // 片方のページのみが記録されている場合
      Memo(
        id = MemoId(value = ""),
        content = "メモ",
        pageRange = PageRange(
          start = Int.MAX_VALUE,
          end = null,
        ),
        createdAt = LocalDateTime.now(),
        editedAt = null,
        publishedAt = null,
        likeCount = 0,
      ),
      // ページが記録されていない場合
      Memo(
        id = MemoId(value = ""),
        content = "メモ",
        pageRange = null,
        createdAt = LocalDateTime.now(),
        editedAt = null,
        publishedAt = null,
        likeCount = 0,
      ),
      // 編集済みの場合
      Memo(
        id = MemoId(value = ""),
        content = "メモ",
        pageRange = PageRange(
          start = Int.MAX_VALUE,
          end = null,
        ),
        createdAt = LocalDateTime.now(),
        editedAt = LocalDateTime.now(),
        publishedAt = null,
        likeCount = 0,
      ),
      // 複数行の場合
      Memo(
        id = MemoId(value = ""),
        content = "日本人はものをうまく作ることに取り憑かれている米国人はとにかく仕事を終えることを考える。",
        pageRange = PageRange(
          start = Int.MAX_VALUE,
          end = null,
        ),
        createdAt = LocalDateTime.now(),
        editedAt = null,
        publishedAt = null,
        likeCount = 0,
      ),
    )
}
