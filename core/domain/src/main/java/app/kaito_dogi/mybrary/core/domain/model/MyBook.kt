package app.kaito_dogi.mybrary.core.domain.model

import app.kaito_dogi.mybrary.core.common.model.Url
import kotlinx.serialization.Serializable

/**
 * Mybrary に登録した本
 *
 * @property id MyBook の ID
 * @property title タイトル
 * @property imageUrl 表紙画像の URL
 * @property authorList 著者のリスト
 * @property publisher 出版社名
 * @property isbn ISBN コード
 * @property genre ジャンル
 * @property rakutenUrl Rakuten Books のアフィリエイト URL
 * @property isPinned ピン留めされているか
 * @property isFavorite お気に入りに登録されているか
 * @property isArchived アーカイブされているか
 */
@Serializable
data class MyBook(
  val id: MyBookId,
  val title: String,
  val imageUrl: Url.Image,
  val authorList: List<Author>,
  val publisher: String,
  val isbn: String,
  val genre: Genre,
  val rakutenUrl: Url.Affiliate,
  val isPinned: Boolean,
  val isFavorite: Boolean,
  val isArchived: Boolean,
)
