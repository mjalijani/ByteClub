package com.game.byteclub.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DowrCategoryService {

    @GET("/dowr/category/")
    fun getCategory(
        @Query("name") query: String
    ): Call<List<String>>

}