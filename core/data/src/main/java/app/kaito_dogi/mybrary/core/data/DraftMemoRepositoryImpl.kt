package app.kaito_dogi.mybrary.core.data

import app.kaito_dogi.mybrary.core.domain.model.Draft
import app.kaito_dogi.mybrary.core.domain.repository.DraftMemoRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.Flow

@Singleton
internal class DraftMemoRepositoryImpl @Inject constructor() : DraftMemoRepository {
  override val draftMemos: Flow<List<Draft>>
    get() = TODO("Not yet implemented")
}
