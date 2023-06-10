package app.doggy.core.database

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

internal val MIGRATION_1_2 = object : Migration(1, 2) {
  override fun migrate(database: SupportSQLiteDatabase) {
    database.execSQL(
      """
        ALTER TABLE books ADD COLUMN registered_at INTEGER;
        ALTER TABLE records ADD COLUMN recorded_at INTEGER;
        """,
    )
  }
}

internal val MIGRATION_2_3 = object : Migration(2, 3) {
  override fun migrate(database: SupportSQLiteDatabase) {
    database.execSQL(
      """
        ALTER TABLE authors ALTER COLUMN id INTEGER;
        """,
    )
  }
}

internal val MIGRATION_3_4 = object : Migration(3, 4) {
  override fun migrate(database: SupportSQLiteDatabase) {
    database.execSQL(
      """
        ALTER TABLE authors ADD COLUMN book_id INTEGER;
        """,
    )
  }
}
