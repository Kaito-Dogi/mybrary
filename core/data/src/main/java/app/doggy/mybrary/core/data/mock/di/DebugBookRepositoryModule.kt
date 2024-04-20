package app.doggy.mybrary.core.data.di

import app.doggy.mybrary.core.data.repository.BookRepositoryImpl
import app.doggy.mybrary.core.domain.repository.BookRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

// @Module
// @InstallIn(SingletonComponent::class)
// internal interface DebugBookRepositoryModule {
//
//   @Binds
//   fun bindsBookRepository(
//     bookRepository: BookRepositoryImpl,
//   ): BookRepository
// }
