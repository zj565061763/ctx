package com.sd.lib.ctx

import android.annotation.SuppressLint
import android.content.Context

@SuppressLint("StaticFieldLeak")
object FContext {
    private var _context: Context? = null

    @JvmStatic
    fun set(context: Context?) {
        if (context == null) return
        this._context = context.applicationContext
    }

    @JvmStatic
    fun get(): Context = checkNotNull(_context)
}

val fContext: Context get() = FContext.get()