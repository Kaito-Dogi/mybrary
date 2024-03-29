package app.doggy.mybrary.core.database.util

import androidx.room.withTransaction
import app.doggy.mybrary.core.database.MybraryDatabase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RoomTransactionExecutor @Inject constructor(
  private val database: MybraryDatabase,
) {
  suspend fun <R> execute(block: suspend () -> R): R = database.withTransaction(block)
}
