package io.amosbake.library

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Message
import android.util.Log
import io.amosbake.library.broadcast.BroadcasterHelper
import io.amosbake.library.screen.DefaultScreenStatusListener
import io.amosbake.library.screen.ScreenStatusBroadcastReceiver
import java.util.logging.Logger

/**
 * Created by Yanhao
 * date: 17/8/21
 */
class ScreenGuardService : Service() {
    companion object {
        val ACTION_KEY = "action"
        val ACTION_UNKOWN = -1
        val ACTION_LISTEN_LOCKSCREEN = 1
        val STATUS_TIME = 2
        val STATUS_BATTERY = 4

        val MSG_SHOW = 1
        val TAG = "ScreenGuardService"
    }

    private var status: Int = 0
    val broadcastHelper:BroadcasterHelper = BroadcasterHelper(this)

    override fun onBind(p0: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val action = intent?.getIntExtra(ACTION_KEY, ACTION_UNKOWN) ?: ACTION_UNKOWN
        when(action){
            ACTION_LISTEN_LOCKSCREEN ->{
                broadcastHelper.registerBatteryStatuListener(ScreenStatusBroadcastReceiver())
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
    }


}