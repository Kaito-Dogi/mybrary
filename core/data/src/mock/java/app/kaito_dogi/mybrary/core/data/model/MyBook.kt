package app.kaito_dogi.mybrary.core.data.model

import app.kaito_dogi.mybrary.core.common.model.Url
import app.kaito_dogi.mybrary.core.domain.model.MyBook
import app.kaito_dogi.mybrary.core.domain.model.MyBookId

internal val dummyMyBooks = buildList {
  repeat(20) { myBookIndex ->
    val myBookId = MyBookId(myBookIndex.toLong())
    add(
      MyBook(
        id = myBookId,
        externalId = "MyBook$myBookId",
        title = when (myBookIndex % 7) {
          0 -> "プリンシプル オブ プログラミング3年目までに身につけたい一生役立つ101の原理原則"
          1 -> "ハッカーと画家"
          2 -> "オブジェクト指向UIデザイン使いやすいソフトウェアの原理"
          3 -> "ユースケース駆動開発実践ガイド"
          4 -> "Clean Architecture　達人に学ぶソフトウェアの構造と設計"
          5 -> "Kotlinイン・アクション"
          else -> "title"
        },
        authors = when (myBookIndex % 7) {
          0 -> "上田勲"
          1 -> ""
          2 -> "ソシオメディア, 上野学, 藤井幸多"
          3 -> "ダグ・ローゼンバーグ, マット・ステファン"
          4 -> "Ｒｏｂｅｒｔ　Ｃ．Ｍａｒｔｉｎ"
          5 -> "ＤｍｉｔｒｙＪｅｍｅｒｏｖ, ＳｖｅｔｌａｎａＩｓａｋｏｖａ, 長澤太郎, 藤原聖, 山本純平, ｙｙ＿ｙａｎｋ"
          else -> "authos"
        },
        imageUrl = Url.Image(
          when (myBookIndex % 7) {
            0 -> "https://books.google.com/books/content?id=RuKoDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
            1 -> "https://books.google.com/books/content?id=SinFRfuTH7IC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
            2 -> "https://books.google.com/books/content?id=1FGpzQEACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api"
            3 -> "https://books.google.com/books/content?id=IUp4CwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
            4 -> "https://books.google.com/books/content?id=1f9lDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
            5 -> "https://books.google.com/books/content?id=4TKQswEACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api"
            else -> "imageUrl"
          },
        ),
        isPinned = false,
        isFavorite = false,
        isArchived = false,
      ),
    )
  }
}
