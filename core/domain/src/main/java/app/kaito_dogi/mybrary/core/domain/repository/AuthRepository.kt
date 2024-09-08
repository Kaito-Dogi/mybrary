package app.kaito_dogi.mybrary.core.domain.repository

// FIXME: 後ほど削除する
interface AuthRepository {
  // FIXME: 適切な定義箇所に移動する
  suspend fun hasSession(): Boolean
}
