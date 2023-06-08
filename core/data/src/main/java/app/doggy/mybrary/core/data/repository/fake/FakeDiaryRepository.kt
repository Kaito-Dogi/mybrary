package app.doggy.mybrary.core.data.repository.fake

import app.doggy.mybrary.core.domain.model.legacy.Diary
import app.doggy.mybrary.core.domain.repository.DiaryRepository
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class FakeDiaryRepository @Inject constructor() : DiaryRepository {
  override suspend fun recordDiary(
    diary: Diary,
    bookId: Long,
  ): Boolean = withContext(Dispatchers.IO) {
    delay(1000L)
    true
  }
}
