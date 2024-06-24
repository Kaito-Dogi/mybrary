package app.kaito_dogi.mybrary.core.data.repository

import app.kaito_dogi.mybrary.core.common.model.Url
import app.kaito_dogi.mybrary.core.domain.model.Author
import app.kaito_dogi.mybrary.core.domain.model.AuthorId
import app.kaito_dogi.mybrary.core.domain.model.BookId
import app.kaito_dogi.mybrary.core.domain.model.ExternalBookId
import app.kaito_dogi.mybrary.core.domain.model.MyBook
import app.kaito_dogi.mybrary.core.domain.model.MyBookId
import app.kaito_dogi.mybrary.core.domain.model.User
import app.kaito_dogi.mybrary.core.domain.model.UserId
import app.kaito_dogi.mybrary.core.domain.repository.MyBookRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

@Singleton
internal class MockMyBookRepository @Inject constructor() : MyBookRepository {
  private val mockMyBookList = MutableStateFlow(MockMyBookList)

  override suspend fun getMyBookList(): List<MyBook> {
    delay(1_000)

    return mockMyBookList.value
  }

  override suspend fun getMyBook(
    myBookId: MyBookId,
  ): MyBook {
    delay(1_000)

    return mockMyBookList.value.first { it.id == myBookId }
  }

  // TODO: 実装
  override suspend fun registerMyBook(
    externalBookId: String,
  ): Boolean {
    return true
  }

  override suspend fun pinMyBook(
    myBookId: MyBookId,
  ): MyBook {
    delay(1_000)

    val myBook = mockMyBookList.value.first { it.id == myBookId }
    val pinedMyBook = myBook.copy(isPinned = true)
    val newMyBookList = mockMyBookList.value.map {
      if (it.id == myBookId) pinedMyBook else it
    }
    mockMyBookList.update { newMyBookList }

    return pinedMyBook
  }

  override suspend fun addMyBookToFavorites(
    myBookId: MyBookId,
  ): MyBook {
    delay(1_000)

    val myBook = mockMyBookList.value.first { it.id == myBookId }
    val addedMyBook = myBook.copy(isFavorite = true)
    val newMyBookList = mockMyBookList.value.map {
      if (it.id == myBookId) addedMyBook else it
    }
    mockMyBookList.update { newMyBookList }

    return addedMyBook
  }

  override suspend fun removeMyBookFromFavorites(myBookId: MyBookId): MyBook {
    delay(1_000)

    val myBook = mockMyBookList.value.first { it.id == myBookId }
    val removedMyBook = myBook.copy(isFavorite = false)
    val newMyBookList = mockMyBookList.value.map {
      if (it.id == myBookId) removedMyBook else it
    }
    mockMyBookList.update { newMyBookList }

    return removedMyBook
  }

  override suspend fun archiveMyBook(
    myBookId: MyBookId,
  ): MyBook {
    delay(1_000)

    val myBook = mockMyBookList.value.first { it.id == myBookId }
    val archivedMyBook = myBook.copy(isArchived = true)
    val newMyBookList = mockMyBookList.value.map {
      if (it.id == myBookId) archivedMyBook else it
    }
    mockMyBookList.update { newMyBookList }

    return archivedMyBook
  }
}

private val MockMyBookList = List(10) {
  MyBook(
    id = MyBookId(value = it.toLong()),
    bookId = BookId(value = it.toLong()),
    externalId = ExternalBookId(value = "externalId$it"),
    user = User(
      id = UserId(value = 0L),
      name = "name",
    ),
    title = when (it % 7) {
      0 -> "プリンシプル オブ プログラミング3年目までに身につけたい一生役立つ101の原理原則"
      1 -> "ハッカーと画家"
      2 -> "オブジェクト指向UIデザイン使いやすいソフトウェアの原理"
      3 -> "ユースケース駆動開発実践ガイド"
      4 -> "Clean Architecture　達人に学ぶソフトウェアの構造と設計"
      5 -> "Kotlinイン・アクション"
      else -> "タイトル"
    },
    imageUrl = Url.Image(
      when (it % 7) {
        0 -> "https://books.google.com/books/content?id=RuKoDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
        1 -> "https://books.google.com/books/content?id=SinFRfuTH7IC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
        2 -> "https://books.google.com/books/content?id=1FGpzQEACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api"
        3 -> "https://books.google.com/books/content?id=IUp4CwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
        4 -> "https://books.google.com/books/content?id=1f9lDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
        5 -> "https://books.google.com/books/content?id=4TKQswEACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api"
        else -> ""
      },
    ),
    isbn10 = "isbn10",
    isbn13 = "isbn13",
    pageCount = it * 100,
    authors = when (it % 7) {
      0 -> listOf(Author(id = AuthorId(value = 0L), name = "上田勲"))
      1 -> emptyList()
      2 -> listOf(
        "ソシオメディア",
        "上野学",
        "藤井幸多",
      ).mapIndexed { index, name -> Author(id = AuthorId(value = index.toLong()), name = name) }

      3 -> listOf("ダグ・ローゼンバーグ", "マット・ステファン").mapIndexed { index, name ->
        Author(
          id = AuthorId(value = index.toLong()),
          name = name,
        )
      }

      4 -> listOf(Author(id = AuthorId(value = 0L), name = "Ｒｏｂｅｒｔ　Ｃ．Ｍａｒｔｉｎ"))
      5 -> listOf(
        "ＤｍｉｔｒｙＪｅｍｅｒｏｖ",
        "ＳｖｅｔｌａｎａＩｓａｋｏｖａ",
        "長澤太郎",
        "藤原聖",
        "山本純平",
        "ｙｙ＿ｙａｎｋ",
      ).mapIndexed { index, name -> Author(id = AuthorId(value = index.toLong()), name = name) }

      else -> listOf(Author(id = AuthorId(value = 0L), name = "著者"))
    },
    isPinned = false,
    isFavorite = false,
    isArchived = false,
  )
}
