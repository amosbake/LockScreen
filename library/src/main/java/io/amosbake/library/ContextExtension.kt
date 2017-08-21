package io.amosbake.library

import android.content.Context
import android.app.KeyguardManager
import android.telecom.TelecomManager
import android.telephony.TelephonyManager


/**
 * Created by Yanhao
 * date: 17/8/21
 */
fun Context.isLockScreen():Boolean = (getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager).inKeyguardRestrictedInputMode()

fun Context.isCalling():Boolean {
    val telephonyManager = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    return telephonyManager.callState == TelephonyManager.CALL_STATE_OFFHOOK || telephonyManager.callState == TelephonyManager.CALL_STATE_RINGING
}