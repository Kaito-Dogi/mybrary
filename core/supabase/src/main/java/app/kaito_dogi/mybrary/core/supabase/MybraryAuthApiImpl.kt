package app.kaito_dogi.mybrary.core.supabase

import app.kaito_dogi.mybrary.core.api.mybrary.MybraryAuthApi
import io.github.jan.supabase.SupabaseClient
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class MybraryAuthApiImpl @Inject constructor(
  private val supabaseClient: SupabaseClient,
) : MybraryAuthApi {
  override suspend fun postMyBook() {
    TODO("Not yet implemented")
  }

  override suspend fun putMyBook(id: Long) {
    TODO("Not yet implemented")
  }

  override suspend fun deleteMyBook(id: Long) {
    TODO("Not yet implemented")
  }

  override suspend fun postMemo() {
    TODO("Not yet implemented")
  }

  override suspend fun putMemo(id: Long) {
    TODO("Not yet implemented")
  }

  override suspend fun deleteMemo(id: Long) {
    TODO("Not yet implemented")
  }
}
