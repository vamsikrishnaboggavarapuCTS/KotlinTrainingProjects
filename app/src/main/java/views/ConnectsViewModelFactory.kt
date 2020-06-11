package views

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import repositories.ConnectsRepository
import viewmodels.ConnectsViewModel

class ConnectsViewModelFactory(private val repository: ConnectsRepository): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ConnectsViewModel(repository) as T
    }
}