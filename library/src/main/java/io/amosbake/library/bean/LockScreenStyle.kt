package io.amosbake.library.bean

import android.app.Activity

/**
 * Created by Yanhao
 * date: 17/8/23
 */
data class LockScreenStyle(val activityClass:Class<Activity> ,val category:Category)

enum class Category{
    CHARGE,COMMON
}