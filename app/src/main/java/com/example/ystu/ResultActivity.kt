package com.example.ystu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ystu.databinding.ActivityResultBinding


class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        binding.numberField.text = intent.getStringExtra("counter")
    }
}