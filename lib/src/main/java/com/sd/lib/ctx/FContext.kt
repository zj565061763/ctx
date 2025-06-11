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
    context?.applicationContext?.also { _context = it }
  }

  @JvmStatic
  fun get(): Context = checkNotNull(_context)
}

val fContext: Context get() = FContext.get()

/** 从[Context]中查找[Activity]，如果找不到则返回null */
tailrec fun Context?.fFindActivityOrNull(): Activity? = when (this) {
  is Activity -> this
  is ContextWrapper -> baseContext.fFindActivityOrNull()
  else -> null
}