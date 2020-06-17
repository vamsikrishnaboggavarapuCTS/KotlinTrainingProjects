package network

import Util.Constants
import models.ConnectModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface ConnectsApi {

    @GET("users?page=1")
    suspend fun getConnects():Response<ConnectModel>

    companion object{
        operator fun invoke() : ConnectsApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.ConnectsApiBaseUrl)
                .build()
                .create(ConnectsApi::class.java)
        }
    }
}