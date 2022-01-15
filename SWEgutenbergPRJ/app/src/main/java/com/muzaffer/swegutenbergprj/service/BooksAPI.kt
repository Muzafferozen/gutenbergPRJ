package com.muzaffer.swegutenbergprj.service

import com.muzaffer.swegutenbergprj.model.BooksModel
import com.muzaffer.swegutenbergprj.view.HomePageFragment
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface BooksAPI {

    @GET("books/search/:query")
    fun getData (): Call<List<BooksModel>>







}