package com.example.utaronew.data.API

import com.example.utaronew.data.models.Retrofit.DailyGoroTodayModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DailyGoroApi {

    @GET("{sign}")
    fun getHoroscopeToday(@Path("sign")sign:String) : Call<DailyGoroTodayModel>

//    companion object {
//
//        var BASE_URL = "https://ohmanda.com/api/horoscope/"
//
//        fun create() : DailyGoroApi {
//
//            val interceptor = HttpLoggingInterceptor()
//            interceptor.level = HttpLoggingInterceptor.Level.BODY
//            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
//
//            val retrofit = Retrofit.Builder()
//                .addConverterFactory(GsonConverterFactory.create())
//                .baseUrl(BASE_URL)
//                .client(client)
//                .build()
//            return retrofit.create(DailyGoroApi::class.java)
//        }
//    }
}
