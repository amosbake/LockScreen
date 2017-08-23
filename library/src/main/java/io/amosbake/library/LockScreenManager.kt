package io.amosbake.library

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import io.amosbake.library.bean.Category
import io.amosbake.library.bean.Configs
import io.amosbake.library.bean.LockScreenStyle
import io.amosbake.library.broadcast.BroadcasterHelper

/**
 * Created by Yanhao
 * date: 17/8/22
 */
object LockScreenManager {
    var isCharging = false
    var isScreenOn = false
    var isForeground = false
    var lockScreenStyles = mutableMapOf<Category,LockScreenStyle>()
    lateinit var configs:Configs

    public fun initialize(app: Application){
        configs = Configs(app.applicationContext)
        app.registerActivityLifecycleCallbacks(object :Application.ActivityLifecycleCallbacks{
            override fun onActivityPaused(p0: Activity?) {
                isForeground = false
            }

            override fun onActivityResumed(p0: Activity?) {
                isForeground = true
            }

            override fun onActivityStarted(p0: Activity?) {
            }

            override fun onActivityDestroyed(p0: Activity?) {
            }

            override fun onActivitySaveInstanceState(p0: Activity?, p1: Bundle?) {
            }

            override fun onActivityStopped(p0: Activity?) {
            }

            override fun onActivityCreated(p0: Activity?, p1: Bundle?) {
            }

        })
    }

    public fun addLockScreenStyle(category: Category,activityClass: Class<Activity>){
        val lockScreenStyle = LockScreenStyle(activityClass, category)
        lockScreenStyles.put(category,lockScreenStyle)
    }

    fun openDefaultLockScreenListener(){

    }



}