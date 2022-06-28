package com.youtubeclone.app.ui

import android.content.Context
import android.content.SharedPreferences

class AppSharedPreferences(context: Context) {

    val preferences = context.getSharedPreferences("My_API", Context.MODE_PRIVATE)

    fun save(keyName: String, value: String?) {
        val editor: SharedPreferences.Editor = preferences.edit()
        editor.putString(keyName, value)
        editor.apply()
    }


    fun getValueString(keyName: String): String? {
        return preferences.getString(keyName, null)
    }

    fun clear() {
        val editor: SharedPreferences.Editor = preferences.edit()
        editor.clear()
        editor.apply()
    }
}