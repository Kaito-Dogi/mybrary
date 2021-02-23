package app.doggy.newmybrary

import com.google.gson.annotations.SerializedName

data class BookData(
    val items: List<Item>
)

data class Item(
    @SerializedName("volumeInfo") val volumeInfo: VolumeInfo
)

data class VolumeInfo(
    val title: String,
    val authors: List<String>,
    @SerializedName("pageCount") val pageCount: Int,
    val description: String?,
    @SerializedName("imageLinks") val imageLinks: ImageLinks
)

data class ImageLinks(
    val thumbnail: String
)