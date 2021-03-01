package com.ajaweed.ajaweedcounter

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by Salam El-Banna on 01/03/2021
 */
object CounterRepository {

    private const val PREFERENCE_NAME = "AJAWEED_PREFS"
    private const val KEY_COUNTER_VALUE = "KEY_COUNTER_VALUE"

    private fun getPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
    }

    fun getCounterValue(context: Context): Int {
        return getPreferences(context).getInt(KEY_COUNTER_VALUE, 0)
    }

    fun setCounterValue(context: Context, newCounterValue: Int) {
        getPreferences(context).edit().putInt(KEY_COUNTER_VALUE, newCounterValue).apply()
    }
}