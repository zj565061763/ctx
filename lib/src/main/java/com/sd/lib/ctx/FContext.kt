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
 * 优先从[Context]中查找[Activity]返回，如果找不到的话使用当前[Context]
 */
fun Context.fPreferActivityContext(): Context = fFindActivityOrNull() ?: this

/**
 * 从[Context]中查找[Activity]，并调用[block]
 */
inline fun Context.fFindActivity(
    block: (Activity) -> Unit,
) {
    fFindActivityOrNull()?.let(block)
}

/**
 * 从[Context]中查找[Activity]，如果找不到的话返回null
 */
tailrec fun Context.fFindActivityOrNull(): Activity? =
    when (this) {
        is Activity -> this
        is ContextWrapper -> baseContext.fFindActivityOrNull()
        else -> null
    }