package com.example.utaronew.data.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.utaronew.data.API.DailyGoroApi
import com.example.utaronew.data.API.GoroUtilites
import com.example.utaronew.data.models.Retrofit.DailyGoroTodayModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DailyGoroRepository(val sign: String){

    val dailyGoro = MutableLiveData<DailyGoroTodayModel>()

    fun getGoro(): MutableLiveData<DailyGoroTodayModel> {

        val call = GoroUtilites.create().getHoroscopeToday(sign)

        call.enqueue(object: Callback<DailyGoroTodayModel> {
            override fun onFailure(call: Call<DailyGoroTodayModel>, t: Throwable) {
                Log.v("DEBUG : ", t.message.toString())
            }
            override fun onResponse(
                call: Call<DailyGoroTodayModel>,
                response: Response<DailyGoroTodayModel>
            ) {
                // TODO("Not yet implemented")
                Log.v("DEBUG : ", response.body().toString())
                dailyGoro.value = DailyGoroTodayModel(response.body()!!.sign, response.body()!!.date, response.body()!!.horoscope)
            }
        })

        return dailyGoro
    }

}
