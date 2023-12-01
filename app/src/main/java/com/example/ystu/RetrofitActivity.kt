package com.example.ystu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ystu.adapter.RetrofitAdapter
import com.example.ystu.dto.UserDTO
import com.example.ystu.viewmodel.RetrofitViewModel

class RetrofitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)


        val viewModel = ViewModelProvider(this)[RetrofitViewModel::class.java]
        viewModel.init()

        val recyclerview = findViewById<RecyclerView>(R.id.retrofit_recycleview)

        val data = mutableListOf<UserDTO>()
        val adapter = RetrofitAdapter(data)

        val dataObserver = Observer<List<UserDTO>> { newData ->
            data.addAll(newData)
            adapter.notifyDataSetChanged();
        }

        viewModel.data.observe(this, dataObserver)

        recyclerview.layoutManager = LinearLayoutManager(this)

        recyclerview.adapter = adapter

    }
}