package com.sd.demo.ctx

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.sd.lib.ctx.fLastActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        logMsg { "onCreate last activity:$fLastActivity" }
    }

    override fun onStart() {
        super.onStart()
        logMsg { "onStart last activity:$fLastActivity" }
    }

    override fun onResume() {
        super.onResume()
        logMsg { "onResume last activity:$fLastActivity" }
    }

    override fun onPause() {
        super.onPause()
        logMsg { "onPause last activity:$fLastActivity" }
    }

    override fun onStop() {
        super.onStop()
        logMsg { "onStop last activity:$fLastActivity" }
    }
}

inline fun logMsg(block: () -> String) {
    Log.i("ctx-demo", block())
}