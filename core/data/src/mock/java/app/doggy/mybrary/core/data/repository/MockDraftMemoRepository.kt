package app.doggy.mybrary.core.data.repository

import app.doggy.mybrary.core.data.model.dummyDraftMemos
import app.doggy.mybrary.core.domain.model.DraftMemo
import app.doggy.mybrary.core.domain.repository.DraftMemoRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class MockDraftMemoRepository @Inject constructor() : DraftMemoRepository {
  override val draftMemos: Flow<List<DraftMemo>> = flow { emit(dummyDraftMemos) }
}
