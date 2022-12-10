package app.doggy.newmybrary.domain.repository

import app.doggy.newmybrary.domain.model.Diary

interface DiaryRepository {
  suspend fun recordDiary(
    diary: Diary,
    bookId: Long,
  ): Boolean
}
