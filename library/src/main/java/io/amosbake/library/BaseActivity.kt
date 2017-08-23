package io.amosbake.library

import android.content.IntentFilter
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.amosbake.library.bean.Category
import io.amosbake.library.broadcast.CloseBroadCastReceiver

/**
 * Created by Yanhao
 * date: 17/8/23
 */
class BaseActivity : AppCompatActivity() {
    companion object {
        val KEY_CATEGORY = "key_category"
    }
    lateinit var category:Category
    private val broadCastReceiver: CloseBroadCastReceiver = CloseBroadCastReceiver(this)
    private val intentFilter:IntentFilter = IntentFilter().apply {
        addAction(CloseBroadCastReceiver.ACTION_CLOSE)
        addAction(CloseBroadCastReceiver.ACTION_CLOSE_ALL)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        category = intent.getSerializableExtra(KEY_CATEGORY) as Category
        registerReceiver(broadCastReceiver,intentFilter)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(broadCastReceiver)
    }
}