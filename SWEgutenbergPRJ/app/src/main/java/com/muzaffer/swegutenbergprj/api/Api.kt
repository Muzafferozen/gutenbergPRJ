package com.muzaffer.swegutenbergprj.api

import com.muzaffer.swegutenbergprj.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("books/search")
    //@Headers("Authorization: token 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")

    fun getSearchUser(
        @Query("q") query: String

    ): Call<UserResponse>


}