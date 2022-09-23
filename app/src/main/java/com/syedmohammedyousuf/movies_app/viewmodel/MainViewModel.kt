package com.syedmohammedyousuf.movies_app.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.syedmohammedyousuf.movies_app.models.MyData
import com.syedmohammedyousuf.movies_app.models.Search
import com.syedmohammedyousuf.movies_app.repository.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel(private val repository: MyViewModelFactory, repository1: MainRepository) : ViewModel() {

    val movieList = MutableLiveData<List<Search>>()
    val errorMessage =MutableLiveData<String>()


    fun getAllMovies(){
        val response = repository.getAllMovies()
        response.enqueue(object : Callback<List<MyData>?> {
            override fun onResponse(call: Call<List<MyData>?>, response: Response<List<MyData>?>) {
                movieList.postValue(response.body()?.mList)
            }

            override fun onFailure(call: Call<List<MyData>?>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })

    }


}