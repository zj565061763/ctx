package com.sd.demo.ctx

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Button
import com.sd.lib.ctx.fFindActivity

class ContextDialog(context: Context) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(
            Button(context).apply {
                this.text = "Dialog Button"
            }
        )
        logMsg { "Dialog context:$context activity:${context.fFindActivity()}" }
    }
}