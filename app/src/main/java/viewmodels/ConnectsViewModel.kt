package viewmodels

import Util.Coroutines
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job
import models.ConnectModel
import repositories.ConnectsRepository

class ConnectsViewModel(private val connectsRepository: ConnectsRepository) : ViewModel() {

    private lateinit var job:Job

    private val _connects = MutableLiveData<ConnectModel>()
    val connects: LiveData<ConnectModel>
        get() = _connects

    fun getConnects(){
        //var response = connectsRepository.getConnects()
        //_connects.value = response

        job =Coroutines.ioThenMain(
            { connectsRepository.getConnects()},
            {_connects.value = it}
        )
    }

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }
}
