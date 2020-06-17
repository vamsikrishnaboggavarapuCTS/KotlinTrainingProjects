package viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import models.*
import repositories.MyWallRepository

class MyWallViewModel(private val repository: MyWallRepository) : ViewModel() {

    private val _mywalls = MutableLiveData<List<MyWallUIModel?>>()
    val mywalls: LiveData<List<MyWallUIModel?>>
        get() = _mywalls

    fun prepareData(){

        runBlocking {

            var myWallResponse = repository.getMyWall()
            var myWallReactionResponse = repository.getMyWallReaction()

            if(null != myWallResponse && null != myWallReactionResponse){
                val id: Map<String, MyWallModelItem> = myWallResponse.associateBy { it.id }

                val result = myWallReactionResponse.filter { id[it.feed_id] != null }.map { x ->
                    id[x.feed_id]?.let { y ->
                        MyWallUIModel(y?.category,y?.id,y?.imageUrl,y?.message,
                            y?.name,y?.postType,y?.profile_pic,y?.timestamp,
                            x?.hate,x?.like,x?.love,x?.total_reactions)
                    }
                }
                _mywalls.value = result
            }
        }
    }
}
