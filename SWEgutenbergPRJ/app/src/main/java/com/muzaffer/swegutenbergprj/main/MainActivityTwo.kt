package com.muzaffer.swegutenbergprj.main

import android.os.Bundle
import android.os.PersistableBundle
import android.view.KeyEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.muzaffer.swegutenbergprj.databinding.ActivityBooksBinding
import kotlinx.android.synthetic.main.activity_books.*


class MainActivityTwo : AppCompatActivity() {
    private lateinit var binding: ActivityBooksBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        binding = ActivityBooksBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = UserAdapter()
        adapter.notifyDataSetChanged()
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(MainViewModel::class.java)
        binding.apply {


            rvUser.layoutManager = LinearLayoutManager(this@MainActivityTwo)
            rvUser.setHasFixedSize(true)
            rvUser.adapter = adapter

            btnSearch.setOnClickListener {

                searchUser()
            }

            etQuery.setOnKeyListener { v, keyCode, event ->

                if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER){
                    searchUser()
                    return@setOnKeyListener true
                }
                return@setOnKeyListener false
            }



        }

        viewModel.getSearchUsers().observe(this,{

            if(it!=null){

                adapter.setList(it)
                showLoading(false)
            }


        })


    }

    private fun searchUser(){

        binding.apply {

            val query = etQuery.text.toString()
            if (query.isEmpty()) return
            showLoading(true)
            viewModel.setSearchUser(query)

        }

    }

    private fun showLoading(state: Boolean) {

        if (state) {
            binding.progressBar.visibility = View.VISIBLE


        }
        else {

            binding.progressBar.visibility = View.GONE
        }

    }

}