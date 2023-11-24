package com.example.ystu.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ystu.R
import com.example.ystu.viewmodel.CounterViewModel

class CounterFragment : Fragment(R.layout.fragment_counter) {
    private var inflatedView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inflatedView = inflater.inflate(R.layout.fragment_counter, container, false)
        val textView = inflatedView?.findViewById<TextView>(R.id.number_field)
        val minusButton = inflatedView?.findViewById<TextView>(R.id.minus_button)
        val plusButton = inflatedView?.findViewById<TextView>(R.id.plus_button)

        val counterViewModel = ViewModelProvider(this)[CounterViewModel::class.java]
        counterViewModel.init()

        val counterObserver = Observer<Int> { newCounter ->
            textView?.text = newCounter.toString()
        }

        counterViewModel.counter.observe(viewLifecycleOwner, counterObserver)

        textView?.text = counterViewModel.counter.value.toString()

        plusButton?.setOnClickListener {
            counterViewModel.increment()
        }
        minusButton?.setOnClickListener {
            counterViewModel.decrement()
        }

        return inflatedView
    }

    companion object {
    }
}