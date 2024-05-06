package com.sd.demo.ctx

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        logMsg { "Activity:$this" }
        ContextDialog(this).show()
    }
}

inline fun logMsg(block: () -> String) {
    Log.i("ctx-demo", block())
}