package com.example.app.utils

import android.util.Log
import com.crashlytics.android.Crashlytics
import timber.log.Timber

class ReleaseTree: Timber.Tree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG) {
            return
        }

        Crashlytics.log(priority, tag, message)
        t?.let { Crashlytics.logException(it) }
    }
}
