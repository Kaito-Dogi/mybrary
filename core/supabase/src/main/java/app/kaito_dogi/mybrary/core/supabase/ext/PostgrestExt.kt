package app.kaito_dogi.mybrary.core.supabase.ext

import app.kaito_dogi.mybrary.core.supabase.model.Rpc
import app.kaito_dogi.mybrary.core.supabase.model.RpcParameters
import app.kaito_dogi.mybrary.core.supabase.model.Table
import io.github.jan.supabase.gotrue.PostgrestFilterDSL
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.query.Columns
import io.github.jan.supabase.postgrest.query.PostgrestRequestBuilder
import io.github.jan.supabase.postgrest.query.PostgrestUpdate
import io.github.jan.supabase.postgrest.query.filter.PostgrestFilterBuilder
import io.github.jan.supabase.postgrest.result.PostgrestResult
import io.github.jan.supabase.postgrest.rpc

internal suspend fun Postgrest.select(
  table: Table,
  request: @PostgrestFilterDSL PostgrestRequestBuilder.() -> Unit = {},
): PostgrestResult = this
  .from(table = table.value)
  .select(
    columns = Columns.raw(value = table.columnsAll),
    request = request,
  )

internal suspend inline fun <reified T : Any> Postgrest.insert(
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

internal suspend inline fun Postgrest.update(
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

internal suspend fun Postgrest.rpc(
  rpc: Rpc,
  parameters: RpcParameters,
  filter: @PostgrestFilterDSL PostgrestFilterBuilder.() -> Unit,
): PostgrestResult = this
  .rpc(
    function = rpc.name,
    parameters = parameters,
    request = {
      select(
        columns = Columns.raw(
          value = rpc.table.columnsAll,
        ),
      )
      filter(filter)
    },
  )
