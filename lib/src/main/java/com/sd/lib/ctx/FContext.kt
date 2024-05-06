package com.sd.lib.ctx

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.ContextWrapper

@SuppressLint("StaticFieldLeak")
object FContext {
    @Volatile
    private var _context: Context? = null

    @JvmStatic
    fun set(context: Context?) {
        context?.applicationContext?.let {
            _context = it
        }
    }

    @JvmStatic
    fun get(): Context = checkNotNull(_context)
}

val fContext: Context get() = FContext.get()

/**
 * 查找Activity
 */
tailrec fun Context.fFindActivity(): Activity? =
    when (this) {
        is Activity -> this
        is ContextWrapper -> baseContext.fFindActivity()
        else -> null
    }