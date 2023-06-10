package app.doggy.mybrary.core.domain.repository.legacy

import app.doggy.mybrary.core.domain.model.legacy.LegacyDiary

interface LegacyDiaryRepository {
  suspend fun recordDiary(
    legacyDiary: LegacyDiary,
    bookId: Long,
  ): Boolean
}
