package repositories

import network.ConnectsApi
import network.SafeApiRequest

class ConnectsRepository(private val api:ConnectsApi) : SafeApiRequest(){

    suspend fun getConnects() = apiRequest { api.getConnects() }
}