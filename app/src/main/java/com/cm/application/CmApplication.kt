package com.cm.application

import android.app.Application
import com.cm.Utilities.Utility
import com.raizlabs.android.dbflow.config.FlowConfig
import com.raizlabs.android.dbflow.config.FlowLog
import com.raizlabs.android.dbflow.config.FlowManager

/**
 * Created by magicwand on 4/15/2018.
 */
class CmApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        //instantiating DBFlow
        Utility.application = this
        FlowManager.init(FlowConfig.Builder(Utility.application).build())
        //add serious logging
        FlowLog.setMinimumLoggingLevel(FlowLog.Level.V)

        //ApplicationListener.Companion.register();

    }

    override fun onTerminate() {
        super.onTerminate()
       // ApplicationListener.Companion.unregister();

    }
}
