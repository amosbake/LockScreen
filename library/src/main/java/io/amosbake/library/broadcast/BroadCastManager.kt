package io.amosbake.library.broadcast

import android.content.BroadcastReceiver
import android.content.Context

/**
 * Created by Yanhao
 * date: 17/8/21
 */
class BroadCastManager(val context: Context) {
    val broadcastHelper :BroadcasterHelper = BroadcasterHelper(context)
    val broadcastReceivers:MutableList<BroadcastReceiver> = mutableListOf()
    fun addScreenOnListener(){
    }
}
