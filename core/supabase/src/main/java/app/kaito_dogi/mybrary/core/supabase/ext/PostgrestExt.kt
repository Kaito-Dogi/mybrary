package app.kaito_dogi.mybrary.core.supabase.ext

import app.kaito_dogi.mybrary.core.supabase.model.Table
import io.github.jan.supabase.gotrue.PostgrestFilterDSL
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.query.Columns
import io.github.jan.supabase.postgrest.query.PostgrestRequestBuilder
import io.github.jan.supabase.postgrest.result.PostgrestResult

internal suspend fun Postgrest.fromSelectColumnsAll(
  table: Table,
  request: @PostgrestFilterDSL PostgrestRequestBuilder.() -> Unit = {},
) = this
  .from(table = table.value)
  .select(
    columns = Columns.raw(value = table.columnsAll),
    request = request,
  )

internal suspend inline fun <reified T : Any> Postgrest.fromInsertSelectColumnsAll(
  value: T,
  table: Table,
): PostgrestResult = this
  .from(table = table.value)
  .insert(value) {
    select(
      columns = Columns.raw(
        value = table.columnsAll,
      ),
    )
  }
