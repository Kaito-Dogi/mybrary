package app.doggy.core.database

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object : Migration(1, 2) {
  override fun migrate(database: SupportSQLiteDatabase) {
    database.execSQL(
      """
        ALTER TABLE books ADD COLUMN registered_at INTEGER;
        ALTER TABLE records ADD COLUMN recorded_at INTEGER;
        """,
    )
  }
}
