package com.example.ystu

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ystu.databinding.ActivityMainBinding
import com.example.ystu.viewmodel.CounterViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val counterViewModel = ViewModelProvider(this)[CounterViewModel::class.java]
        counterViewModel.init()

        val counterObserver = Observer<Int> { newCounter ->
            binding.numberField.text = newCounter.toString()
        }

        counterViewModel.counter.observe(this, counterObserver)

        binding.numberField.text = counterViewModel.counter.value.toString()

        binding.plusButton.setOnClickListener {
            counterViewModel.increment()
        }
        binding.minusButton.setOnClickListener {
            counterViewModel.decrement()
        }
        binding.secondScreen.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("counter", counterViewModel.counter.value.toString())
            startActivity(intent)
        }
    }
}