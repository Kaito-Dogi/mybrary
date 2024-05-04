package app.kaito_dogi.mybrary.core.data

import app.kaito_dogi.mybrary.core.domain.model.DraftMemo
import app.kaito_dogi.mybrary.core.domain.repository.DraftMemoRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class DraftMemoRepositoryImpl @Inject constructor() : DraftMemoRepository {
  // TODO: 実装
  override val draftMemos: Flow<List<DraftMemo>> = flow { emit(emptyList()) }
}
