package app.kaito_dogi.mybrary.core.supabase

import app.kaito_dogi.mybrary.core.api.mybrary.MybraryApi
import app.kaito_dogi.mybrary.core.api.mybrary.response.GetMyBookResponse
import app.kaito_dogi.mybrary.core.api.mybrary.response.GetMyBooksResponse
import app.kaito_dogi.mybrary.core.api.mybrary.response.model.MyBookResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class MybraryApiImpl @Inject constructor() : MybraryApi {
  override suspend fun getMyBooks(): GetMyBooksResponse {
    return emptyList()
  }

  override suspend fun getMyBook(myBookId: Long): GetMyBookResponse {
    return MyBookResponse(
      id = 0,
      title = "",
    )
  }

  override suspend fun postMyBooks() {
    TODO("Not yet implemented")
  }

  override suspend fun putMyBooks() {
    TODO("Not yet implemented")
  }

  override suspend fun getMemos() {
    TODO("Not yet implemented")
  }

  override suspend fun postMemos() {
    TODO("Not yet implemented")
  }

  override suspend fun putMemos() {
    TODO("Not yet implemented")
  }

  override suspend fun getUser() {
    TODO("Not yet implemented")
  }
}
