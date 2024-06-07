package com.sd.demo.ctx

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.sd.lib.ctx.fFindActivity
import com.sd.lib.ctx.fFindActivityOrNull

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        logMsg { "Activity:$this" }
        ContextDialog(this).show()

        logMsg {
            "fFindActivityOrNull:${fFindActivityOrNull()}"
        }
        
        fFindActivity {
            logMsg { "fFindActivity:$it" }
        }
    }
}

inline fun logMsg(block: () -> String) {
    Log.i("ctx-demo", block())
}