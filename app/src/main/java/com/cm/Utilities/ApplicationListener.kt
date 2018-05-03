package com.cm.Utilities

import de.halfbit.tinybus.Subscribe

/**
 * Created by magicwand on 4/18/2018.
 */

class ApplicationListener {


    @Subscribe(mode = Subscribe.Mode.Background)
    fun startSyncEvent(startSyncEvent: Events.StartSyncEvent) {
        if (Utility.application.isConnected()) doStartSync(startSyncEvent)
    }

    private fun doStartSync(startSyncEvent: Events.StartSyncEvent) {
        Utility.executors.execute {
            Utility.application.doSafely("Syncing Data"){
                //Synchronizer(Utility.application, startSyncEvent.manualSync).sync()
            }
        }
    }

    companion object {
        private val listener = ApplicationListener()

        fun register() = Events.tinyBus.register(listener)

        fun unregister() = Events.tinyBus.unregister(listener)

    }
}
