package app.kaito_dogi.mybrary.core.domain.repository

import app.kaito_dogi.mybrary.core.domain.model.DraftMemo
import kotlinx.coroutines.flow.Flow

interface DraftMemoRepository {
  val draftMemoList: Flow<List<DraftMemo>>
}
