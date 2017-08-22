package io.amosbake.library.bean

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color

/**
 * Created by Yanhao
 * date: 17/8/22
 */
class Configs(context: Context) {
    val PREFS_FILENAME = "lockscreen.prefs"
    val KEY_SWITCH = "switch"
    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME, 0);

    var switch: Boolean
        get() = prefs.getBoolean(KEY_SWITCH,false)
        set(value) = prefs.edit().putBoolean(KEY_SWITCH, value).apply()
}