package com.example.utaronew.data.API

import com.example.utaronew.data.models.Retrofit.DailyPhraseModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface DailyPhraseApi {

    @GET("dailyphrase")
    fun getHoroscope() : Call<DailyPhraseModel>


//    companion object {
//
//        var BASE_URL = "https://horoscope-astrology.p.rapidapi.com/"
//
//        fun create() : DailyPhraseApi {
//            val interseptor = HttpLoggingInterceptor()
//            interseptor.level = HttpLoggingInterceptor.Level.BODY
//            val client = OkHttpClient.Builder()
//                .addInterceptor { chain ->
//                    val originalRequest = chain.request()
//                    val request = originalRequest.newBuilder()
//                        .header("X-RapidAPI-Key", "c82a020c89msh32f87358d53aa59p18792ajsn6383a39155bb")
//                        .header("X-RapidAPI-Host", "horoscope-astrology.p.rapidapi.com")
//                        .build()
//                    chain.proceed(request)
//                }.addInterceptor(interseptor)
//                .build()
//
//            val retrofit = Retrofit.Builder()
//                .addConverterFactory(GsonConverterFactory.create())
//                .baseUrl(BASE_URL)
//                .client(client)
//                .build()
//            return retrofit.create(DailyPhraseApi::class.java)
//
//        }
//    }
}