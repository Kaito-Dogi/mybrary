package app.kaito_dogi.mybrary.core.supabase.ext

import app.kaito_dogi.mybrary.core.supabase.model.Table
import io.github.jan.supabase.gotrue.PostgrestFilterDSL
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.query.Columns
import io.github.jan.supabase.postgrest.query.PostgrestRequestBuilder
import io.github.jan.supabase.postgrest.query.PostgrestUpdate
import io.github.jan.supabase.postgrest.query.filter.PostgrestFilterBuilder
import io.github.jan.supabase.postgrest.result.PostgrestResult

internal suspend fun Postgrest.fromSelectColumnsAll(
  table: Table,
  request: @PostgrestFilterDSL PostgrestRequestBuilder.() -> Unit = {},
): PostgrestResult = this
  .from(table = table.value)
  .select(
    columns = Columns.raw(value = table.columnsAll),
    request = request,
  )

internal suspend inline fun <reified T : Any> Postgrest.fromInsertSelectColumnsAll(
  table: Table,
  value: T,
): PostgrestResult = this
  .from(table = table.value)
  .insert(value) {
    select(
      columns = Columns.raw(
        value = table.columnsAll,
      ),
    )
  }

internal suspend inline fun Postgrest.fromUpdateSelectColumnsAll(
  table: Table,
  crossinline update: PostgrestUpdate.() -> Unit,
  filter: @PostgrestFilterDSL PostgrestFilterBuilder.() -> Unit,
): PostgrestResult = this
  .from(table = table.value)
  .update(update = update) {
    select(
      columns = Columns.raw(
        value = table.columnsAll,
      ),
    )
    filter(filter)
  }
