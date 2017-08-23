package io.amosbake.library.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter

/**
 * Created by Yanhao
 * date: 17/8/21
 */
class BroadcasterHelper (val context: Context, val intentFilter: IntentFilter = IntentFilter()) {

    private fun register(broadcaster: BroadcastReceiver, vararg actions: String) {
        for (action in actions) {
            intentFilter.addAction(action)
        }
        context.registerReceiver(broadcaster,intentFilter)
    }

    fun unRegister(broadcaster: BroadcastReceiver){
        context.unregisterReceiver(broadcaster)
    }

    fun registerScreenListener(broadcastReceiver: BroadcastReceiver){
        register(broadcastReceiver,Intent.ACTION_SCREEN_ON,Intent.ACTION_SCREEN_OFF)
    }

    fun registerPowerStatuListener(broadcastReceiver: BroadcastReceiver){
        register(broadcastReceiver,Intent.ACTION_POWER_CONNECTED,Intent.ACTION_POWER_DISCONNECTED)
    }

    fun registerBatteryStatuListener(broadcastReceiver: BroadcastReceiver){
        register(broadcastReceiver,Intent.ACTION_BATTERY_LOW,Intent.ACTION_BATTERY_OKAY)
    }

}
