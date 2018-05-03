package com.cm.Utilities

import com.cm.application.CmApplication
import java.util.concurrent.Executors

/**
 * Created by magicwand on 4/17/2018.
 */
class Utility {
    companion object {
        lateinit var application: CmApplication
        val ONLINE_DATA_LINK ="http://clinicmaster.com"
        val executors = Executors.newFixedThreadPool(2)!!
    }
}