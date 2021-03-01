package com.ajaweed.ajaweedcounter

/**
 * Created by Salam El-Banna on 01/03/2021
 */
class PrefsManager {

    private var counterValue = 0

    fun increment() {
        counterValue++
    }

    fun reset() {
        counterValue = 0
    }

}