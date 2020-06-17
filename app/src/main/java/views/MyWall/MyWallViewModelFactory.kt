package views.MyWall

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import repositories.MyWallRepository
import viewmodels.MyWallViewModel

class MyWallViewModelFactory(private val repository: MyWallRepository): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MyWallViewModel(repository) as T
    }
}