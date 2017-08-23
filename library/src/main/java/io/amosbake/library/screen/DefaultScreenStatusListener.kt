package io.amosbake.library.screen

import android.content.Context
import android.content.Intent
import android.view.View
import io.amosbake.library.BaseActivity
import io.amosbake.library.LockScreenManager
import io.amosbake.library.bean.Category
import io.amosbake.library.broadcast.CloseBroadCastReceiver
import io.amosbake.library.isLockScreen
import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * Created by Yanhao
 * date: 17/8/22
 */
class DefaultScreenStatusListener(val context: Context) : ScreenStatusListener {
    private val executor: Executor = Executors.newSingleThreadExecutor()

    override fun screenOn() {
        //更新屏幕状态
        if (LockScreenManager.isCharging) {
            //充电,关闭常规锁屏
            closeLockScreenActivity(Category.COMMON)
        } else {
            //未充电,关闭充电锁屏
            closeLockScreenActivity(Category.CHARGE)
        }
        executor.execute({
            val chargeDelayTime = LockScreenManager.configs.chargeDelayTime
            Thread.sleep(chargeDelayTime.toLong())
            if (LockScreenManager.isScreenOn && context.isLockScreen()){
                try {
                   startLockScreenActivity(Category.CHARGE)
                }catch (e:Exception){
                    //ignore
                }
            }
        })
    }

    override fun screenOff() {

    }

    /***拉起锁屏*/
    fun startLockScreenActivity(category: Category) {
        val lockScreenStyle = LockScreenManager.lockScreenStyles[category]
        if (lockScreenStyle != null) {
            val intent = Intent(context, lockScreenStyle.activityClass).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            context.startActivity(intent)
        }
    }

    /**关闭锁屏**/
    fun closeLockScreenActivity(category: Category) {
        val intent = Intent(CloseBroadCastReceiver.ACTION_CLOSE).apply {
            putExtra(BaseActivity.KEY_CATEGORY, category)
        }
        context.sendBroadcast(intent)
    }
}