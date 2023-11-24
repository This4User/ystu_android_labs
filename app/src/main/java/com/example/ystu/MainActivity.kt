package com.example.ystu

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.ystu.databinding.ActivityMainBinding
import com.example.ystu.viewmodel.CounterViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.secondScreen.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            val counterViewModel = ViewModelProvider(this)[CounterViewModel::class.java]
            counterViewModel.init()
            intent.putExtra("counter", counterViewModel.counter.value.toString())
            startActivity(intent)
        }
    }
}