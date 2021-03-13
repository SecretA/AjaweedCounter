package com.ajaweed.ajaweedcounter

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.view.animation.ScaleAnimation
import androidx.appcompat.app.AppCompatActivity
import com.ajaweed.ajaweedcounter.databinding.ActivityCounterBinding


/**
 * Created by Salam El-Banna on 01/03/2021
 */
class CounterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCounterBinding
    private var counterValue = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCounterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupFullScreenMode()

        binding.increment.setOnClickListener {
            animate()
            counterValue++
            CounterRepository.setCounterValue(this, counterValue)
            updateCounterText()
        }

        binding.reset.setOnClickListener {
            showConfirmationDialog()
        }
    }

    private fun showConfirmationDialog() {
        AlertDialog.Builder(this)
            .setTitle(R.string.reset_counter)
            .setMessage(R.string.are_you_sure)
            .setCancelable(false)
            .setPositiveButton(R.string.reset) { _, _ ->
                setupFullScreenMode()
                counterValue = 0
                CounterRepository.setCounterValue(this, counterValue)
                updateCounterText()
            }
            .setNegativeButton(R.string.cancel) { dialog, _ ->
                setupFullScreenMode()
                dialog.dismiss()
            }.create().show()
    }

    override fun onResume() {
        super.onResume()
        counterValue = CounterRepository.getCounterValue(this)
        updateCounterText()
        setupFullScreenMode()
    }

    private fun updateCounterText() {
        binding.counterDisplay.text = counterValue.toString()
    }

    @Suppress("DEPRECATION")
    @SuppressLint("InlinedApi")
    private fun setupFullScreenMode() {
        supportActionBar?.hide()

        // Note that some of these constants are new as of API 16 (Jelly Bean)
        // and API 19 (KitKat). It is safe to use them, as they are inlined
        // at compile-time and do nothing on earlier devices.
        binding.container.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LOW_PROFILE or
                    View.SYSTEM_UI_FLAG_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
    }

    private fun animate() {
        val animationScale = 0.98.toFloat()
        val scale = ScaleAnimation(animationScale, animationScale, animationScale, animationScale)
        scale.duration = 50
        binding.increment.startAnimation(scale)
    }
}