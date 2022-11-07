package app.doggy.newmybrary.legacy

import retrofit2.http.GET
import retrofit2.http.Query

interface BookDataService {

    @GET("volumes")
    suspend fun getBook(@Query("q") q: String): BookData

}
