package app.kaito_dogi.mybrary.core.data.datasource

import app.kaito_dogi.mybrary.core.data.command.PatchMemoCommand
import app.kaito_dogi.mybrary.core.data.command.PostMemoCommand
import app.kaito_dogi.mybrary.core.data.dto.MemoDto

interface MemoRemoteDataSource {
  suspend fun getMemos(myBookId: String): List<MemoDto>

  suspend fun postMemo(command: PostMemoCommand): MemoDto

  suspend fun patchMemo(command: PatchMemoCommand): MemoDto

  suspend fun deleteMemo(memoId: String)
}
