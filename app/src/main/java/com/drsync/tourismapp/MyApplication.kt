package com.drsync.tourismapp

import android.app.Application
import com.drsync.tourismapp.core.di.CoreComponent
import com.drsync.tourismapp.core.di.DaggerCoreComponent
import com.drsync.tourismapp.di.AppComponent
import com.drsync.tourismapp.di.DaggerAppComponent


open class MyApplication : Application() {

    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.factory().create(applicationContext)
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(coreComponent)
    }
}