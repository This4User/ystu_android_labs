package com.example.ystu.viewmodel

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.os.Handler
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData


class CounterViewModel(application: Application) : AndroidViewModel(application) {
    private val delay = 3.toLong()

    val counter: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>(0)
    }

    private var sharedPref: SharedPreferences =
        getApplication<Application>().getSharedPreferences(
            "counter",
            Context.MODE_PRIVATE,
        )

    fun init() {
        counter.value = sharedPref.getInt("counter", 0)
    }

    fun increment(num: Int? = 1) {
        Handler().postDelayed(
            {
                this.counter.value = this.counter.value?.plus(num ?: 1)

                this.counter.value?.let { this.updateCachedValue(it) }
            }, this.delay * 1000
        )
    }

    fun decrement(num: Int? = 1) {
        Handler().postDelayed(
            {
                this.counter.value = this.counter.value?.minus(num ?: 1)

                this.counter.value?.let { this.updateCachedValue(it) }
            }, this.delay * 1000
        )
    }

    private fun updateCachedValue(score: Int) {
        with(sharedPref.edit()) {
            putInt("counter", score)
            apply()
        }
    }
}