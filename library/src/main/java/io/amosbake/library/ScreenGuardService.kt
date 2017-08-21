package io.amosbake.library

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Message
import android.util.Log
import java.util.logging.Logger

/**
 * Created by Yanhao
 * date: 17/8/21
 */
class ScreenGuardService : Service() {
    companion object {
        val STATUS_KEY = "status"
        val STATUS_LOCK_SCREEN = 1
        val STATUS_TIME = 2
        val STATUS_BATTERY = 4

        val MSG_SHOW = 1
        val TAG = "ScreenGuardService"
    }

    private var status: Int = 0
    private val handler: Handler = object : Handler() {

        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            if (msg?.what == MSG_SHOW) {
                Log.i(TAG, "status " + status)
                sendEmptyMessageDelayed(MSG_SHOW, 500)
            }
        }
    }

    override fun onBind(p0: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        var result = super.onStartCommand(intent, flags, startId)
        status = intent?.getIntExtra(STATUS_KEY, 0) ?: 0
        handler.removeMessages(MSG_SHOW)
        handler.sendEmptyMessageDelayed(MSG_SHOW, 300)
        return result
    }

    override fun onDestroy() {
        super.onDestroy()
    }


}