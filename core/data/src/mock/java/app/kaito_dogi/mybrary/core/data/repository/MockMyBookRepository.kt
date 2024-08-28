package app.kaito_dogi.mybrary.core.data.repository

import app.kaito_dogi.mybrary.core.common.coroutines.dispatcher.Dispatcher
import app.kaito_dogi.mybrary.core.common.coroutines.dispatcher.MybraryDispatchers
import app.kaito_dogi.mybrary.core.common.model.Url
import app.kaito_dogi.mybrary.core.domain.model.Author
import app.kaito_dogi.mybrary.core.domain.model.Book
import app.kaito_dogi.mybrary.core.domain.model.BookId
import app.kaito_dogi.mybrary.core.domain.model.MyBook
import app.kaito_dogi.mybrary.core.domain.model.MyBookId
import app.kaito_dogi.mybrary.core.domain.model.User
import app.kaito_dogi.mybrary.core.domain.model.UserId
import app.kaito_dogi.mybrary.core.domain.repository.MyBookRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.withContext

@Singleton
internal class MockMyBookRepository @Inject constructor(
  @Dispatcher(MybraryDispatchers.IO) private val dispatcher: CoroutineDispatcher,
) : MyBookRepository {
  private val mockMyBookList = MutableStateFlow(MockMyBookList)

  override suspend fun getMyBookList(): List<MyBook> {
    delay(1_000)

    return mockMyBookList.value
  }

  override suspend fun getMyBook(
    myBookId: MyBookId,
  ): MyBook = withContext(dispatcher) {
    delay(1_000)

    return@withContext mockMyBookList.value.first { it.id == myBookId }
  }

  override suspend fun registerMyBook(book: Book): MyBook = withContext(dispatcher) {
    delay(1_000)

    val myBook = MyBook(
      id = MyBookId(value = "${mockMyBookList.value.size}"),
      user = mockMyBookList.value[0].user,
      bookId = book.id,
      title = book.title,
      imageUrl = book.imageUrl,
      isbn = book.isbn,
      publisher = book.publisher,
      authors = book.authors,
      isPinned = false,
      isFavorite = false,
      isPublic = false,
      isArchived = false,
    )

    mockMyBookList.update { it + myBook }

    return@withContext myBook
  }

  override suspend fun pinMyBook(myBookId: MyBookId): MyBook = withContext(dispatcher) {
    delay(1_000)

    val myBook = mockMyBookList.value.first { it.id == myBookId }
    val pinedMyBook = myBook.copy(isPinned = true)
    val newMyBookList = mockMyBookList.value.map {
      if (it.id == myBookId) pinedMyBook else it
    }
    mockMyBookList.update { newMyBookList }

    return@withContext pinedMyBook
  }

  override suspend fun addMyBookToFavorites(myBookId: MyBookId): MyBook = withContext(dispatcher) {
    delay(1_000)

    val myBook = mockMyBookList.value.first { it.id == myBookId }
    val addedMyBook = myBook.copy(isFavorite = true)
    val newMyBookList = mockMyBookList.value.map {
      if (it.id == myBookId) addedMyBook else it
    }
    mockMyBookList.update { newMyBookList }

    return@withContext addedMyBook
  }

  override suspend fun removeMyBookFromFavorites(myBookId: MyBookId): MyBook =
    withContext(dispatcher) {
      delay(1_000)

      val myBook = mockMyBookList.value.first { it.id == myBookId }
      val removedMyBook = myBook.copy(isFavorite = false)
      val newMyBookList = mockMyBookList.value.map {
        if (it.id == myBookId) removedMyBook else it
      }
      mockMyBookList.update { newMyBookList }

      return@withContext removedMyBook
    }

  override suspend fun makeMyBookPublic(myBookId: MyBookId): MyBook = withContext(dispatcher) {
    delay(1_000)

    val myBook = mockMyBookList.value.first { it.id == myBookId }
    val publicMyBook = myBook.copy(isPublic = true)
    val newMyBookList = mockMyBookList.value.map {
      if (it.id == myBookId) publicMyBook else it
    }
    mockMyBookList.update { newMyBookList }

    return@withContext publicMyBook
  }

  override suspend fun makeMyBookPrivate(myBookId: MyBookId): MyBook = withContext(dispatcher) {
    delay(1_000)

    val myBook = mockMyBookList.value.first { it.id == myBookId }
    val privateMyBook = myBook.copy(isPublic = false)
    val newMyBookList = mockMyBookList.value.map {
      if (it.id == myBookId) privateMyBook else it
    }
    mockMyBookList.update { newMyBookList }

    return@withContext privateMyBook
  }

  override suspend fun archiveMyBook(myBookId: MyBookId): MyBook = withContext(dispatcher) {
    delay(1_000)

    val myBook = mockMyBookList.value.first { it.id == myBookId }
    val archivedMyBook = myBook.copy(isArchived = true)
    val newMyBookList = mockMyBookList.value.map {
      if (it.id == myBookId) archivedMyBook else it
    }
    mockMyBookList.update { newMyBookList }

    return@withContext archivedMyBook
  }
}

private val MockMyBookList = List(20) { index ->
  MyBook(
    id = MyBookId(value = "$index"),
    user = User(
      id = UserId(value = "userId"),
      name = "ユーザー名",
    ),
    bookId = BookId(value = "$index"),
    title = when (index % 7) {
      0 -> "プリンシプル オブ プログラミング 3年目までに身につけたい 一生役立つ101の原理原則"
      1 -> "ハッカーと画家"
      2 -> "オブジェクト指向UIデザイン使いやすいソフトウェアの原理"
      3 -> "ユースケース駆動開発実践ガイド"
      4 -> "Clean Architecture"
      5 -> "Kotlinイン・アクション"
      else -> "タイトル"
    },
    // FIXME: 楽天 API から取得される値に置き換える
    imageUrl = Url.Image(
      when (index % 7) {
        0 -> "https://books.google.com/books/content?id=RuKoDwAAQBAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api"
        1 -> "https://books.google.com/books/content?id=SinFRfuTH7IC&printsec=frontcover&img=1&zoom=1&source=gbs_api"
        2 -> "https://books.google.com/books/content?id=1FGpzQEACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api"
        3 -> "https://books.google.com/books/content?id=IUp4CwAAQBAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api"
        4 -> "https://books.google.com/books/content?id=GRjUuQEACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api"
        5 -> "https://books.google.com/books/content?id=E323DwAAQBAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api"
        else -> ""
      },
    ),
    isbn = "isbn",
    publisher = when (index % 7) {
      0 -> "秀和システム"
      1 -> "株式会社 オーム社"
      2 -> ""
      3 -> "翔泳社"
      4 -> ""
      5 -> "マイナビ出版"
      else -> "出版社"
    },
    authors = when (index % 7) {
      0 -> listOf(Author(name = "上田勲"))
      1 -> emptyList()
      2 -> listOf(
        "ソシオメディア",
        "上野学",
        "藤井幸多",
      ).map { Author(name = it) }

      3 -> listOf("ダグ・ローゼンバーグ", "マット・ステファン").map { Author(name = it) }

      4 -> listOf(Author(name = "ロバート・C. マーチン"))
      5 -> listOf(
        "ＤｍｉｔｒｙＪｅｍｅｒｏｖ",
        "ＳｖｅｔｌａｎａＩｓａｋｏｖａ",
        "長澤太郎",
        "藤原聖",
        "山本純平",
        "ｙｙ＿ｙａｎｋ",
      ).map { Author(name = it) }

      else -> listOf(Author(name = "著者名"))
    },
    isPinned = false,
    isFavorite = false,
    isPublic = false,
    isArchived = false,
  )
}
