package app.kaito_dogi.mybrary.core.domain.model

import app.kaito_dogi.mybrary.core.common.model.Url
import kotlinx.serialization.Serializable

/**
 * 書籍検索結果の書籍
 *
 * @property id 書籍の ID
 * @property title タイトル
 * @property imageUrl 表紙画像の URL
 * @property authorList 著者のリスト
 * @property publisher 出版社名
 * @property isbn ISBN コード
 * @property genre ジャンル
 * @property rakutenUrl Rakuten Books のアフィリエイト URL
 * @property amazonUrl Amazon のアフィリエイト URL
 */
@Serializable
data class Book(
  val id: BookId,
  val title: String,
  val imageUrl: Url.Image,
  val authorList: List<Author>,
  val publisher: String,
  val isbn: String,
  val genre: Genre,
  val rakutenUrl: Url.Affiliate,
  val amazonUrl: Url.Affiliate? = null,
)
