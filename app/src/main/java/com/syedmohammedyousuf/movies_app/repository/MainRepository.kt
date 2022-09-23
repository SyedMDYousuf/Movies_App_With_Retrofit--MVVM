package com.syedmohammedyousuf.movies_app.repository

import com.syedmohammedyousuf.movies_app.network.RetrofitService

class MainRepository(retrofitService: RetrofitService) {
    class MainRepository constructor(private val retrofitService: RetrofitService) {

        fun getAllMovies() = retrofitService.getAllMovies()
    }
}