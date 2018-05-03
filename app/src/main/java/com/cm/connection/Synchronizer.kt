package com.cm.connection

import android.annotation.SuppressLint
import android.content.Context
import com.dewarder.akommons.defaultSharedPreferences
import khronos.Dates
import khronos.toDate
import khronos.toString
import java.util.*
import java.util.concurrent.TimeUnit
import java.util.concurrent.locks.ReentrantReadWriteLock

/**
 * Created by magicwand on 4/18/2018.
 */
class Synchronizer(private val ctx: Context,
                   private val manualSync: Boolean) {

//    fun sync() {
//        if (isTimeToSoon()) return
//        upload()
//        delete()
//        download()
//    }
//
//
//    private fun upload() {
//        assertConnected()
//        Uploader(Globals.application).upload()
//    }
//
//    private fun download() {
//        assertConnected()
//        DataDownloader(Globals.application).download()
//    }
//
//    private fun delete() {
//        DeleteSync(Globals.application).deleteAnimals()
//    }
//
//    fun uploadAsync(whenDone: () -> Unit, onError: (message: String) -> Unit) {
//        Globals.executors.execute {
//            try {
//                upload()
//                whenDone()
//            } catch (x: Exception) {
//                onError(x.message ?: "Technical Error Uploading")
//            }
//        }
//    }
//
//
//    fun assertConnected() {
//        if (!ctx.isConnected()) throw ElundaException("Phone not Connected")
//    }
//
//    private fun isTimeToSoon(): Boolean {
//        try {
//            doLock()
//
//            if (!shouldRun()) {
//                ctx.dShortToast("*****SYNC RUN RECENTLY SYNCING ABORTING [${Synchronizer.syncCount}].TRY AGAIN IN 30 SECONDS*****")
//                return true
//            }
//            setLastRun()
//        } finally {
//            doUnlock()
//        }
//        return false
//    }
//
//
//    @SuppressLint("CommitPrefEdits")
//    private fun setLastRun() {
//        val editor = ctx.defaultSharedPreferences.edit()
//        val nowStamp = Dates.today.toString(LG_TIME_STAMP_FORMAT)
//        d("======Setting last Sync Time [$nowStamp]")
//        editor.putString(KEY_SETTING_LAST_SYNC_ID, nowStamp)
//        editor.commit()
//    }
//
//    private fun shouldRun(): Boolean {
//        val dateStr = ctx.defaultSharedPreferences.getString(KEY_SETTING_LAST_SYNC_ID, Date(1).toTimeStamp())
//        val d: Date = doSafely { dateStr.toDate(format = LG_TIME_STAMP_FORMAT) } ?: Date(1)
//        d("======Last Sync Time is: [$dateStr]")
//        val sleepDuration = if (manualSync) SYNC_MANUAL_PAUSE_TIME else SYNC_BACKGROUND_FORCE_PAUSE_PERIOD
//        return isPeriodPassed(d, sleepDuration, SYNC_SLEEP_UNIT)
//    }
//
//    private fun Date.toTimeStamp(): String = toString(LG_TIME_STAMP_FORMAT)
//
//
//    companion object {
//
//        const val KEY_SETTING_LAST_SYNC_ID = "last_sync_time"
//        const val SYNC_MANUAL_PAUSE_TIME = 30L//Amount of time a manual sync must wait before another starts
//        val SYNC_SLEEP_UNIT = TimeUnit.SECONDS//Units used
//        val SYNC_BACKGROUND_FORCE_PAUSE_PERIOD = SYNC_SLEEP_UNIT.convert(4, TimeUnit.HOURS)
//        const val LG_TIME_STAMP_FORMAT = "yyyy-MM-dd HH:mm:ss"
//
//        private var syncCount = 0
//        private val lock = ReentrantReadWriteLock()
//
//
//        private fun doLock() {
//            lock.writeLock().lock()
//        }
//
//        private fun doUnlock() {
//            lock.writeLock().unlock()
//        }
//    }


}