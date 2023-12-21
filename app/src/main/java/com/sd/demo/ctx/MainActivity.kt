package com.sd.demo.ctx

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.sd.lib.ctx.FLastActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        logMsg { "onCreate last activity ${FLastActivity.get()}" }
    }

    override fun onStart() {
        super.onStart()
        logMsg { "onStart last activity ${FLastActivity.get()}" }
    }

    override fun onResume() {
        super.onResume()
        logMsg { "onResume last activity ${FLastActivity.get()}" }
    }

    override fun onPause() {
        super.onPause()
        logMsg { "onPause last activity ${FLastActivity.get()}" }
    }

    override fun onStop() {
        super.onStop()
        logMsg { "onStop last activity ${FLastActivity.get()}" }
    }
}

inline fun logMsg(block: () -> String) {
    Log.i("ctx-demo", block())
}