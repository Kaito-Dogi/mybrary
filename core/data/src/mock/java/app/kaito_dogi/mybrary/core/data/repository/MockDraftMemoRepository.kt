package app.kaito_dogi.mybrary.core.data.repository

import app.kaito_dogi.mybrary.core.data.model.dummyDraftMemos
import app.kaito_dogi.mybrary.core.domain.model.DraftMemo
import app.kaito_dogi.mybrary.core.domain.repository.DraftMemoRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class MockDraftMemoRepository @Inject constructor() : DraftMemoRepository {
  override val draftMemos: Flow<List<DraftMemo>> = flow { emit(dummyDraftMemos) }
}
