package io.amosbake.library.screen

import android.content.Context
import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * Created by Yanhao
 * date: 17/8/22
 */
class DefaultScreenStatusListener(context: Context) : ScreenStatusListener {
    private val executor: Executor = Executors.newSingleThreadExecutor()

    override fun screenOn() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



    override fun screenOff() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}