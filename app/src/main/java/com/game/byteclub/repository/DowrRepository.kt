package com.game.byteclub.repository

import androidx.lifecycle.MutableLiveData
import com.game.byteclub.api.DowrCategoryService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory


class DowrRepository {

    companion object {
        const val BASE_URL = "https://www.byteclub.ir/api/"
    }

    private var categoryResponseLiveData: MutableLiveData<List<String>> = MutableLiveData()
    private var categoryService: DowrCategoryService

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        categoryService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

    fun getCategory(name: String) {
        categoryService.getCategory(name).enqueue(object : Callback<List<String>> {
            override fun onResponse(call: Call<List<String>>, response: Response<List<String>>) {
                categoryResponseLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<List<String>>, t: Throwable) {
                // TODO : handle error
            }

        })
    }

    fun getCategory(): MutableLiveData<List<String>> {
        return categoryResponseLiveData
    }


}