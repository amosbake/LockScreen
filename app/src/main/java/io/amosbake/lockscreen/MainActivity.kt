package io.amosbake.lockscreen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import io.amosbake.library.ScreenGuardService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var commandValue = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = Intent(this,ScreenGuardService::class.java)
        intent.putExtra("status",1)
        startService(intent)
    }

    override fun onResume() {
        super.onResume()
        submit.setOnClickListener {
            val intent = Intent(this,ScreenGuardService::class.java)
            intent.putExtra("status",commandValue)
            startService(intent)
            commandValue++
        }
    }
}
