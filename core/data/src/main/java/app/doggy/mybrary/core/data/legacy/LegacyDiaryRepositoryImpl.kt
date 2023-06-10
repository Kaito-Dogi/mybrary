package app.doggy.mybrary.core.data.legacy

import app.doggy.mybrary.core.data.legacy.fake.FakeLegacyDiaryRepository
import app.doggy.mybrary.core.domain.repository.legacy.LegacyDiaryRepository
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
  fun FakeLegacyDiaryRepository.bindDiaryRepository(): LegacyDiaryRepository
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
