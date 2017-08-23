package io.amosbake.library.screen

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import io.amosbake.library.LockScreenManager
import io.amosbake.library.isCalling

/**
 * Created by Yanhao
 * date: 17/8/22
 */
class ScreenStatusBroadcastReceiver : BroadcastReceiver() {
    private var screenStatuListeners = mutableListOf<ScreenStatusListener>()

    override fun onReceive(context: Context, intent: Intent) {
        if (context.isCalling() && LockScreenManager.configs.switch) {
            if(intent.action?.equals(Intent.ACTION_SCREEN_ON) == true){
                LockScreenManager.isScreenOn = true
                screenOn()
            }else if (intent.action?.equals(Intent.ACTION_SCREEN_OFF) == true){
                LockScreenManager.isScreenOn = false
                screenOff()
            }
        }
    }

    fun addScreenStatusListener(screenStatusListener: ScreenStatusListener){
        screenStatuListeners.add(screenStatusListener)
    }

    fun removeScreenStatusListener(screenStatusListener: ScreenStatusListener){
        screenStatuListeners.remove(screenStatusListener)
    }

    fun removeAllListeners(){
        screenStatuListeners.clear()
    }

    fun screenOn(){
        for (listener in screenStatuListeners){
            listener.screenOn()
        }
    }

    fun screenOff(){
        for (listener in screenStatuListeners){
            listener.screenOff()
        }
    }
}