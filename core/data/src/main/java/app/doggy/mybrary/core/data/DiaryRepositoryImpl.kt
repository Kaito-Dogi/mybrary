package app.doggy.mybrary.core.data

import app.doggy.mybrary.core.data.fake.FakeDiaryRepository
import app.doggy.mybrary.core.domain.repository.legacy.DiaryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

// FIXME: Hilt モジュールの置き場所を考える
@InstallIn(SingletonComponent::class)
@Module
internal interface DiaryRepositoryModule {
  // fun DiaryRepositoryImpl.bindDiaryRepository(): DiaryRepository
  @Binds
  fun FakeDiaryRepository.bindDiaryRepository(): DiaryRepository
}

// class DiaryRepositoryImpl @Inject constructor(
//   private val db: MybraryDatabase,
// ) : DiaryRepository {
//   override suspend fun recordDiary(
//     diary: Diary,
//     bookId: Long,
//   ): Boolean = withContext(Dispatchers.IO) {
//     db.diaryDao().insert(diary.toDiaryEntity(bookId))
//     true
//   }
// }
