package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding

//New project
class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private var data: Float = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding?.root
        setContentView(view)
        if (savedInstanceState != null) {
            dataBinding(savedInstanceState?.getFloat(DATA_KEY))
        } else {
            dataBinding(0f)
        }
        binding?.slider?.addOnChangeListener { slider, value, fromUser ->
            dataBinding(value)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putFloat(DATA_KEY, data)
    }

    private fun dataBinding(dataBinding: Float) {
        binding?.textRes?.text = "Your data is ${dataBinding}"
        binding?.slider?.value = dataBinding
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    companion object {
        const val DATA_KEY = "123" //ключ Bundle
    }
}