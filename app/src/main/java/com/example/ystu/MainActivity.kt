package com.example.ystu

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ystu.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPref = this.getPreferences(Context.MODE_PRIVATE)
        counter = sharedPref.getInt("counter", 0)
        binding.numberField.text = counter.toString()


        binding.plusButton.setOnClickListener {
            counter += 1

            with(sharedPref.edit()) {
                putInt("counter", counter)
                apply()
            }

            binding.numberField.text = counter.toString()
        }
        binding.minusButton.setOnClickListener {
            counter -= 1

            with(sharedPref.edit()) {
                putInt("counter", counter)
                apply()
            }

            binding.numberField.text = counter.toString()
        }
        binding.secondScreen.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("counter", counter.toString())
            startActivity(intent)
        }
    }
}