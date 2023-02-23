package com.ajaweed.ajaweedcounter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ajaweed.ajaweedcounter.databinding.ActivityCounterBinding


/**
 * Created by Salam El-Banna on 01/03/2021
 */
class CounterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCounterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCounterBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}