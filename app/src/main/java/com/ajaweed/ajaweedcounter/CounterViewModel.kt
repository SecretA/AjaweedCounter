package com.ajaweed.ajaweedcounter

import androidx.lifecycle.ViewModel

/**
 * Created by Salam El-Banna on 01/03/2021
 */
class CounterViewModel : ViewModel() {

    private var counterValue = 0

    fun increment() {
        counterValue++
    }

    fun reset() {
        counterValue = 0
    }

}