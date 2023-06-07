package app.doggy.mybrary.domain.repository

import app.doggy.mybrary.core.domain.model.Diary

interface DiaryRepository {
  suspend fun recordDiary(
    diary: Diary,
    bookId: Long,
  ): Boolean
}
