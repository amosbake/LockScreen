package io.amosbake.library.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.text.TextUtils
import io.amosbake.library.BaseActivity
import io.amosbake.library.bean.Category

/**
 * Created by Yanhao
 * date: 17/8/23
 */
class CloseBroadCastReceiver(private val baseActivity: BaseActivity) : BroadcastReceiver() {

    companion object {
        val ACTION_CLOSE = "close"
        val ACTION_CLOSE_ALL = "close_all"
    }

    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action
        if (TextUtils.equals(action, ACTION_CLOSE)){
            val category: Category = intent.getSerializableExtra(BaseActivity.KEY_CATEGORY) as Category
            if (category == baseActivity.category){
                baseActivity.finish()
            }
        }else if (TextUtils.equals(action, ACTION_CLOSE_ALL)){
            baseActivity.finish()
        }
    }
}