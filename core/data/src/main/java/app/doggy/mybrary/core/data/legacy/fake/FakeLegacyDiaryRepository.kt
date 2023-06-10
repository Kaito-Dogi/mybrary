package app.doggy.mybrary.core.data.legacy.fake

import app.doggy.mybrary.core.domain.model.legacy.LegacyDiary
import app.doggy.mybrary.core.domain.repository.legacy.LegacyDiaryRepository
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class FakeLegacyDiaryRepository @Inject constructor() : LegacyDiaryRepository {
  override suspend fun recordDiary(
    legacyDiary: LegacyDiary,
    bookId: Long,
  ): Boolean = withContext(Dispatchers.IO) {
    delay(1000L)
    true
  }
}
