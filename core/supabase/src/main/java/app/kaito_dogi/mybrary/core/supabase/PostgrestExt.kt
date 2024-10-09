package app.kaito_dogi.mybrary.core.supabase

import io.github.jan.supabase.postgrest.Postgrest

internal fun Postgrest.from(table: Table) = this.from(table = table.value)
