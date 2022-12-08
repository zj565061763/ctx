package com.sd.demo.ctx

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.sd.lib.ctx.fContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        logMsg { "Activity onCreate context:$fContext" }
    }
}

inline fun logMsg(block: () -> String) {
    Log.i("ctx-demo", block())
}