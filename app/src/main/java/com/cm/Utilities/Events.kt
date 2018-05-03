package com.cm.Utilities

import com.cm.Utilities.Utility
import de.halfbit.tinybus.TinyBus

/**
 * Created by magicwand on 4/17/2018.
 */

class Events {

    companion object {
        val tinyBus  : TinyBus get()= TinyBus.from(Utility.application)
    }


    fun TinyBus.unregisterSafe(any:Any){
        if(this.hasRegistered(any)){
            this.unregister(any)
        }
    }

    data class PageChangeEvent (val prevPosition : Int , val currentPosition : Int)
    data class StartSyncEvent(val manualSync: Boolean = false)
}

