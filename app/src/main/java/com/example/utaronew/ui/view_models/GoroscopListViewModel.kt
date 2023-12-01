package com.example.utaronew.ui.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.example.utaronew.data.repositories.GoroRepository
import com.example.utaronew.data.room.entities.GoroscopListEntities


class GoroscopListViewModel(private val repository: GoroRepository) :ViewModel() {

    val goroAll: LiveData<List<GoroscopListEntities>> = repository.goroAll.asLiveData()

}
class GoroscopViewModelFactory(private val repository: GoroRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GoroscopListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return GoroscopListViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}