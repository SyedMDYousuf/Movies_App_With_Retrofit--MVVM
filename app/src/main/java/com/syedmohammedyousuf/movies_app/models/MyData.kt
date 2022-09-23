package com.syedmohammedyousuf.movies_app.models

import com.google.gson.annotations.SerializedName


data class MyData(
    @SerializedName("Search") val mList: List<Search>
)