package com.nsz.kotlin

import android.app.Application
import com.facebook.stetho.Stetho
import com.nsz.kotlin.aac.architecture.lifecycle.LifecycleCallback
import io.realm.Realm
import io.realm.RealmConfiguration

class App : Application() {

    init {
        instance = this
    }

    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()

        val lifecycleCallback = LifecycleCallback()
        registerActivityLifecycleCallbacks(lifecycleCallback)

        Realm.init(this)
        val realmConfiguration = RealmConfiguration.Builder().build()
        Realm.setDefaultConfiguration(realmConfiguration)

        Stetho.initializeWithDefaults(this)
    }

}