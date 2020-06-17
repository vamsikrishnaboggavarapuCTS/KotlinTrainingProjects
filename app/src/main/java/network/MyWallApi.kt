package network

import Util.Constants
import models.MyWallModelItem
import models.MyWallReactionModelItem
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MyWallApi {

    @GET("myWall")
    suspend fun getMyWall():Response<List<MyWallModelItem>>

    @GET("reaction")
    suspend fun getReaction():Response<List<MyWallReactionModelItem>>

    companion object{
        operator fun invoke() : MyWallApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.MyWallApiBaseUrl)
                .build()
                .create(MyWallApi::class.java)
        }
    }
}