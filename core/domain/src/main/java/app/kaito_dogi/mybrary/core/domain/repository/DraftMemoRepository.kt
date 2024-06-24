package app.kaito_dogi.mybrary.core.domain.repository

import app.kaito_dogi.mybrary.core.domain.model.Draft
import kotlinx.coroutines.flow.Flow

interface DraftMemoRepository {
  val draftMemos: Flow<List<Draft>>
}
