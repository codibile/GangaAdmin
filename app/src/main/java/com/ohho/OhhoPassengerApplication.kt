package com.ohho

import android.app.Application
import com.facebook.stetho.Stetho
import com.mlm.recharege.di.NETWORKING_MODULE
import com.mlm.recharege.di.REPOSITORY_MODULE
import com.mlm.recharege.di.VIEW_MODEL_MODULE
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger


import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class OhhoPassengerApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@OhhoPassengerApplication)
            loadKoinModules(REQUIRED_MODULE)
        }
    }

    companion object {
        val REQUIRED_MODULE = listOf(
            NETWORKING_MODULE,
            REPOSITORY_MODULE,
            VIEW_MODEL_MODULE
        )
    }
}




