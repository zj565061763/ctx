package com.sd.demo.ctx

import android.app.Application
import com.sd.lib.ctx.fContext

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        logMsg {
            """
            Application onCreate
            Application:$this
            context:$fContext
            equals:${this === fContext}
            appName:${Constant.APP_NAME}
        """.trimIndent()
        }
    }
}