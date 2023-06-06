package com.sd.lib.ctx

import android.annotation.SuppressLint
import android.content.Context

@SuppressLint("StaticFieldLeak")
object FContext {
    @Volatile
    private var context: Context? = null

    @JvmStatic
    fun set(context: Context?) {
        if (context == null) return
        this.context = context.applicationContext
    }

    @JvmStatic
    fun get(): Context = checkNotNull(context)
}

val fContext: Context get() = FContext.get()