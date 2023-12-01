package com.example.ystu.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.ystu.dto.UserDTO
import com.example.ystu.instances.RetrofitClient
import kotlinx.coroutines.launch


class RetrofitViewModel(application: Application) : AndroidViewModel(application) {
    val data = MutableLiveData<List<UserDTO>>(listOf())

    fun init() {
        viewModelScope.launch {
            val users = RetrofitClient.instance.getUsers()
            data.postValue(users)
        }
    }
}