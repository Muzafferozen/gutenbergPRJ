package com.muzaffer.swegutenbergprj.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.muzaffer.swegutenbergprj.api.RetrofitClient
import com.muzaffer.swegutenbergprj.model.User
import com.muzaffer.swegutenbergprj.model.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel: ViewModel() {

    val listUsers = MutableLiveData<ArrayList<User>>()

    fun setSearchUser(query: String){

        RetrofitClient.apiInstance
            .getSearchUser(query)
            .enqueue(object : Callback<UserResponse>{
                override fun onResponse(
                    call: Call<UserResponse>,
                    response: Response<UserResponse>
                ) {
                    if (response.isSuccessful){

                        listUsers.postValue(response.body()?.items)

                    }

                }

                override fun onFailure(call: Call<UserResponse>, t: Throwable) {


                    Log.d("Failure",t.message.toString())
                }


            })





    }
    fun getSearchUsers(): LiveData<ArrayList<User>> {

        return listUsers

    }



}