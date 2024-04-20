package app.doggy.mybrary.core.domain.repository

import app.doggy.mybrary.core.domain.model.Book

interface BookRepository {
  suspend fun searchBooks(
    keyword: String,
    maxResults: Int,
    startIndex: Int,
    orderBy: OrderType,
    printType: PrintType,
  ): List<Book>
}

enum class OrderType(
  val value: String
) {
  NEWEST("newest"),
  RELEVANCE("relevance"),
  ;
}

enum class PrintType(
  val value: String
) {
  All("all"),
  BOOKS("books"),
  MAGAZINES("magazines"),
  ;
}
