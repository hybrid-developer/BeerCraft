package com.zavaitar.core.mvi.util

import android.os.Bundle

fun Bundle.toMap(): Map<String, Any?> {
    val map = HashMap<String, Any?>()

    val keySet = this.keySet()
    val iterator = keySet.iterator()
    while (iterator.hasNext()) {
        val key = iterator.next()
        map[key] = this.get(key)
    }

    return map
}
