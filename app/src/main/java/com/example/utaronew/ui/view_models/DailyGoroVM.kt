package com.example.utaronew.ui.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.utaronew.data.models.Retrofit.DailyGoroTodayModel
import com.example.utaronew.data.repositories.DailyGoroRepository
import com.example.utaronew.data.repositories.GoroRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import kotlin.math.sign

class DailyGoroVM: ViewModel() {

    var dailyGoro: MutableLiveData<DailyGoroTodayModel>? = null

    fun getGoro(sign:String) : LiveData<DailyGoroTodayModel>? {
        dailyGoro = DailyGoroRepository(sign).getGoro()
        return dailyGoro
    }
}
//class DailyGoroVMFactory(private val goroRepository: DailyGoroRepository, private val sign: String): ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        @Suppress("UNCHECKED_CAST")
//        return DailyGoroVM(goroRepository, sign) as T
//    }
//}
