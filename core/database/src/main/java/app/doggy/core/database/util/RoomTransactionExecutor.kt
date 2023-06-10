package app.doggy.core.database.util

import androidx.room.RoomDatabase
import androidx.room.withTransaction
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RoomTransactionExecutor @Inject constructor(
  val database: RoomDatabase,
) {
  suspend fun <R> execute(block: suspend () -> R): R = database.withTransaction(block)
}
