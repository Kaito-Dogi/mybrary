package app.kaito_dogi.mybrary.core.domain.repository

import app.kaito_dogi.mybrary.core.domain.model.DraftMemo
import app.kaito_dogi.mybrary.core.domain.model.MyBookId

interface DraftMemoRepository {
  suspend fun createDraftMemo(draftMemo: DraftMemo)

  suspend fun updateDraftMemo(draftMemo: DraftMemo)

  suspend fun deleteDraftMemo(draftMemo: DraftMemo)

  suspend fun getDraftMemo(myBookId: MyBookId): DraftMemo
}
