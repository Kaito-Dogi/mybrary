package app.kaito_dogi.mybrary.core.data

import app.kaito_dogi.mybrary.core.domain.model.DraftMemo
import app.kaito_dogi.mybrary.core.domain.repository.DraftMemoRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.Flow

@Singleton
internal class DraftMemoRepositoryImpl @Inject constructor() : DraftMemoRepository {
  override val draftMemoList: Flow<List<DraftMemo>>
    get() = TODO("Not yet implemented")
}
