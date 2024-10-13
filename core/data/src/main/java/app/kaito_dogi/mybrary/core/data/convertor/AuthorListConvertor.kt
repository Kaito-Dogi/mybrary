package app.kaito_dogi.mybrary.core.data.convertor

import app.kaito_dogi.mybrary.core.domain.model.Author

// FIXME: このファイルをここに置くべきか検討する
internal fun String.toAuthorList() = this.split("/").map { Author(name = it) }
