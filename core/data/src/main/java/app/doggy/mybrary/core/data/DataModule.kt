package app.doggy.mybrary.core.data

import app.doggy.mybrary.core.data.impl.BookRepositoryImpl
import app.doggy.mybrary.core.data.impl.RecordRepositoryImpl
import app.doggy.mybrary.core.domain.repository.BookRepository
import app.doggy.mybrary.core.domain.repository.RecordRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface DataModule {

  @Binds
  fun bindsBookRepository(
    bookRepository: BookRepositoryImpl,
  ): BookRepository

  @Binds
  fun bindsRecordRepository(
    recordRepository: RecordRepositoryImpl,
  ): RecordRepository
}
