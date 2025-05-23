package com.example.friendi

import android.app.Application
import com.example.friendi.data.AppContainer
import com.example.friendi.data.DefaultAppContainer

/**
 * Class used for actually initialzing and injecting dependencies when the app starts
 */

class AmphibianApplication : Application() {
    /** AppContainer instance used by the rest of classes to obtain dependencies */
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}