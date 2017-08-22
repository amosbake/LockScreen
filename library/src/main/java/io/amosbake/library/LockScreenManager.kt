package io.amosbake.library

import android.content.Context
import io.amosbake.library.bean.Configs

/**
 * Created by Yanhao
 * date: 17/8/22
 */
object LockScreenManager {
    var isCharging = false
    var isScreenOn = false

    lateinit var configs:Configs

    fun initialize(context: Context){
        configs = Configs(context)
    }

}