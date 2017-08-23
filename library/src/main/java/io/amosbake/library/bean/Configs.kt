package io.amosbake.library.bean

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by Yanhao
 * date: 17/8/22
 */
class Configs(context: Context) {
    val PREFS_FILENAME = "lockscreen.prefs"
    val KEY_SWITCH = "switch"
    val KEY_CHARGE_DELAY = "charge_delay"
    val KEY_NORMAL_DELAY = "normal_delay"
    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME, 0);

    /**锁屏开关**/
    var switch: Boolean
        get() = prefs.getBoolean(KEY_SWITCH,false)
        set(value) = prefs.edit().putBoolean(KEY_SWITCH, value).apply()
    /**充电锁屏延迟拉起时间 -- 确保在其他锁屏的前端**/
    var chargeDelayTime:Int
        get() = prefs.getInt(KEY_CHARGE_DELAY,0)
        set(value) = prefs.edit().putInt(KEY_CHARGE_DELAY,value).apply()

    /**常规锁屏延迟拉起时间 -- 确保在其他锁屏的前端**/
    var normalDelayTime:Int
        get() = prefs.getInt(KEY_NORMAL_DELAY,0)
        set(value) = prefs.edit().putInt(KEY_NORMAL_DELAY,value).apply()
}