package com.example.randomjokesapplication

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    //endpoint
    @GET("joke/Any")
     fun getJoke(): Call<myJokes>  //calling my jokes data model
}