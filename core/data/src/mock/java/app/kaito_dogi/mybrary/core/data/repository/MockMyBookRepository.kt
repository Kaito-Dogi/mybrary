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
      authorList = book.authorList,
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
      2 -> "オブジェクト指向UIデザイン──使いやすいソフトウェアの原理"
      3 -> "ユースケース駆動開発実践ガイド"
      4 -> "Clean Architecture 達人に学ぶソフトウェアの構造と設計"
      5 -> "Kotlinイン・アクション"
      else -> "タイトル"
    },
    imageUrl = Url.Image(
      when (index % 7) {
        0 -> "https://thumbnail.image.rakuten.co.jp/@0_mall/book/cabinet/6143/9784798046143.jpg?_ex=512x512"
        1 -> "https://thumbnail.image.rakuten.co.jp/@0_mall/book/cabinet/2740/27406597.jpg?_ex=512x512"
        2 -> "https://thumbnail.image.rakuten.co.jp/@0_mall/book/cabinet/3513/9784297113513.jpg?_ex=512x512"
        3 -> "https://thumbnail.image.rakuten.co.jp/@0_mall/book/cabinet/7981/79811445.jpg?_ex=512x512"
        4 -> "https://thumbnail.image.rakuten.co.jp/@0_mall/book/cabinet/0659/9784048930659.jpg?_ex=512x512"
        5 -> "https://thumbnail.image.rakuten.co.jp/@0_mall/book/cabinet/1749/9784839961749.jpg?_ex=512x512"
        else -> ""
      },
    ),
    isbn = "isbn",
    publisher = when (index % 7) {
      0 -> "秀和システム"
      1 -> "オーム社"
      2 -> "技術評論社"
      3 -> "翔泳社"
      4 -> "ドワンゴ"
      5 -> "マイナビ出版"
      else -> "出版社"
    },
    authorList = when (index % 7) {
      0 -> listOf(Author(name = "上田　勲"))
      1 -> listOf("ポール・グレアム", "川合史朗").map { Author(name = it) }
      2 -> listOf("ソシオメディア株式会社", "上野 学", "藤井 幸多").map { Author(name = it) }
      3 -> listOf("ダグ・ローゼンバーグ", "マット・ステファン").map { Author(name = it) }
      4 -> listOf("Robert　C．Martin", "角　征典", "高木　正弘").map { Author(name = it) }

      5 -> listOf(
        "Dmitry Jemerov",
        "Svetlana Isakova",
        "長澤 太郎",
        "藤原 聖",
        "山本 純平",
        "yy_yank",
      ).map { Author(name = it) }

      else -> listOf(Author(name = "著者名"))
    },
    isPinned = false,
    isFavorite = false,
    isPublic = false,
    isArchived = false,
  )
}
