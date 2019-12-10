package com.example.app

import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDexApplication
import com.facebook.stetho.Stetho
import com.jakewharton.threetenabp.AndroidThreeTen
import com.example.app.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber
import org.koin.android.ext.koin.androidFileProperties

import com.example.app.utils.ReleaseTree

class MainApplication: MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        AndroidThreeTen.init(this)
        Stetho.initializeWithDefaults(this)

        startKoin()
        installTimber()
    }

    private fun startKoin() {
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            androidFileProperties()
            modules(appModules)
        }
    }

    private fun installTimber() {
        if (BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())
        else
            Timber.plant(ReleaseTree())
    }
}
