package com.sd.lib.ctx

import android.content.Context
import androidx.startup.Initializer

internal class ContextInitializer : Initializer<Context> {
  override fun create(context: Context): Context {
    FContext.set(context)
    return context
  }

  override fun dependencies(): List<Class<out Initializer<*>>> {
    return emptyList()
  }
}