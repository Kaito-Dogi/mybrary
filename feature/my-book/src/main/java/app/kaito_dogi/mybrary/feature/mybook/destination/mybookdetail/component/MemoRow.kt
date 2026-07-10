package app.kaito_dogi.mybrary.feature.mybook.destination.mybookdetail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import app.kaito_dogi.mybrary.core.designsystem.R
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.domain.model.Memo
import app.kaito_dogi.mybrary.core.domain.model.MemoId
import app.kaito_dogi.mybrary.core.domain.model.PageRange
import app.kaito_dogi.mybrary.core.ui.datetime.toFormattedString
import java.time.LocalDateTime

private val ShareButtonSize = 32.dp
private val ShareIconSize = 16.dp

@Composable
internal fun MemoRow(
  memo: Memo,
  onClick: (Memo) -> Unit,
  onShareTextToXClick: (Memo) -> Unit,
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
        bottom = MybraryTheme.spaces.xs,
      ),
      verticalArrangement = Arrangement.spacedBy(space = MybraryTheme.spaces.xxs),
    ) {
      Text(
        text = memo.content,
        modifier = Modifier.fillMaxWidth(),
        style = MybraryTheme.typography.bodyLarge,
      )

      val pageStart = memo.pageRange?.start
      val pageEnd = memo.pageRange?.end
      val page = when {
        pageStart != null && pageEnd != null -> stringResource(
          id = R.string.my_book_detail_text_pp,
          pageStart,
          pageEnd,
        )

        pageStart != null -> stringResource(
          id = R.string.my_book_detail_text_p,
          pageStart,
        )

        else -> ""
      }

      val datetimeText = memo.editedAt?.let { editedAt ->
        stringResource(
          id = R.string.my_book_detail_text_edited,
          editedAt.toFormattedString(),
        )
      } ?: memo.createdAt.toFormattedString()

      val rowBody = if (page.isNotBlank()) "$page｜$datetimeText" else datetimeText
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(space = MybraryTheme.spaces.xxs),
        verticalAlignment = Alignment.CenterVertically,
      ) {
        Text(
          text = rowBody,
          modifier = Modifier.weight(weight = 1f),
          color = MybraryTheme.colorScheme.onSurfaceVariant,
          style = MybraryTheme.typography.bodySmall,
        )

        IconButton(
          onClick = { onShareTextToXClick(memo) },
          modifier = Modifier.size(size = ShareButtonSize),
        ) {
          Icon(
            painter = painterResource(id = R.drawable.icon_x),
            contentDescription = stringResource(id = R.string.my_book_detail_alt_share_memo_to_x),
            modifier = Modifier.size(size = ShareIconSize),
            tint = MybraryTheme.colorScheme.onSurfaceVariant,
          )
        }
      }
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
      onShareTextToXClick = {},
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
      ),
      // ページが記録されていない場合
      Memo(
        id = MemoId(value = ""),
        content = "メモ",
        pageRange = null,
        createdAt = LocalDateTime.now(),
        editedAt = null,
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
      ),
    )
}
