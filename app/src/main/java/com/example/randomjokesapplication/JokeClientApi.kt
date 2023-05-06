package com.example.randomjokesapplication

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object JokeClientApi {

    private const val Base_Url = "https://v2.jokeapi.dev"

    private val retrofit = Retrofit.Builder()
        .baseUrl(Base_Url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val apiService = retrofit.create(ApiInterface::class.java)
}