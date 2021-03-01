package com.ajaweed.ajaweedcounter

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.ajaweed.ajaweedcounter.databinding.ActivityCounterBinding

class CounterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCounterBinding
    private var counterValue = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCounterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupFullScreenMode()

        binding.increment.setOnClickListener {
            counterValue++
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
                counterValue = 0
                updateCounterText()
            }
            .setNegativeButton(R.string.cancel) { dialog, _ ->
                dialog.dismiss()
            }.create().show()
    }

    override fun onResume() {
        super.onResume()
        updateCounterText()
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
}