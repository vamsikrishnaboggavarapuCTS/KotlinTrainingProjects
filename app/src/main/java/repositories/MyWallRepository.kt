package repositories

import network.MyWallApi
import network.SafeApiRequest

class MyWallRepository(private val api:MyWallApi):SafeApiRequest() {
    suspend fun getMyWall() = apiRequest { api.getMyWall() }

    suspend fun getMyWallReaction() =apiRequest { api.getReaction() }
}