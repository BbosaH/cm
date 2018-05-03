package com.cm.Utilities

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.os.Handler
import android.os.Looper
import android.support.annotation.StringRes
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.widget.Toast
import com.dewarder.akommons.defaultSharedPreferences
import com.dewarder.akommons.inputMethodManager
import com.dewarder.akommons.isConnectedToMobile
import com.dewarder.akommons.isConnectedToWifi

/**
 * Created by magicwand on 4/17/2018.
 */

fun Context.isConnected(): Boolean = isConnectedToMobile || isConnectedToWifi

fun Context.inLandScape(): Boolean = resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

fun Context.inPortrait(): Boolean = resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT

fun Context.isDevMode(): Boolean = defaultSharedPreferences.getBoolean("show_cache_indicators", false)

fun Activity.hideKeyBoard() {
    val currentFocus = this.currentFocus
    currentFocus?.let {
        inputMethodManager.hideSoftInputFromInputMethod(it.windowToken, 0)
    }
}

val Int.dp: Int
    get() = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), Resources.getSystem().displayMetrics).toInt()


inline fun <T : Any> doSafely(action: String = "", job: () -> T): T? {
    try {
        return job()
    } catch (x: Exception) {
        e("SAFE-BLOCK", "!!!Error While [$action] :Reason -> ${x.message}")
        x.printStackTrace()
    }
    return null
}

inline fun <T> Context.doSafely(action: String, job: () -> T): T? {
    try {
        return job()
    } catch (x: Exception) {
        this.longToast("Error Occurred While $action: Reason -> ${x.message}")
        x.printStackTrace()
    }
    return null
}

inline fun <T> Context.doSafelyDebug(action: String, job: () -> T): T? {
    try {
        return job()
    } catch (x: Exception) {
        if (this.isDevMode()) {
            this.longToast("Error Occurred While $action: Reason -> ${x.message}")
        }
        e("Error Occurred While $action: Reason -> $x[${x.message}]")
        x.printStackTrace()
    }
    return null
}


fun runOnUiDelayed(action: () -> Unit) {
    lgHandler.postDelayed(action,100)
}

val lgHandler = Handler(Looper.getMainLooper())
fun Context.longToast(msg: String) {
    lgHandler.post { Toast.makeText(this@longToast, msg, Toast.LENGTH_LONG).show() }
}

fun Context.shortToast(msg: String) {
    lgHandler.post { Toast.makeText(this@shortToast, msg, Toast.LENGTH_SHORT).show() }
}

fun Context.dToast(msg: String) {
    if (isDevMode()) {
        lgHandler.post { Toast.makeText(this@dToast, msg, Toast.LENGTH_LONG).show() }
    }
    this.d(msg)
}

fun Context.dShortToast(msg: String) {
    if (isDevMode()) {
        lgHandler.post { Toast.makeText(this@dShortToast, msg, Toast.LENGTH_SHORT).show() }
    }
    this.d(msg)
}

fun View.str(@StringRes resorceId: Int) = this.resources.getString(resorceId)


fun Context.str(@StringRes resorceId: Int) = this.resources.getString(resorceId)


fun textAsBitmap(text: String, textSize: Float, textColor: Int): Bitmap {
    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    paint.textSize = textSize
    paint.color = textColor
    paint.textAlign = Paint.Align.LEFT
    val baseline = -paint.ascent() // ascent() is negative
    val width = (paint.measureText(text) + 0.0f).toInt() // round
    val height = (baseline + paint.descent() + 0.0f).toInt()
    val image = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)

    val canvas = Canvas(image)
    canvas.drawText(text, 0f, baseline, paint)
    return image
}

//LOGGING

fun Any.v(msg: () -> String) {
    if (Log.isLoggable(tag, Log.VERBOSE)) v(msg())
}

fun Any.d(msg: () -> String) {
    if (Log.isLoggable(tag, Log.DEBUG)) d(msg())
}

fun Any.i(msg: () -> String) {
    if (Log.isLoggable(tag, Log.INFO)) i(msg())
}

fun Any.e(msg: () -> String) {
    if (Log.isLoggable(tag, Log.ERROR)) e(msg())
}

fun Any.wtf(msg: () -> String) = w(msg())

fun Any.v(msg: String) = v(tag, msg)

fun Any.d(msg: String) = d(tag, msg)

fun Any.i(msg: String) = i(tag, msg)

fun Any.w(msg: String) = w(tag, msg)

fun Any.e(msg: String) = e(tag, msg)

fun Any.wtf(msg: String) = wtf(tag, msg)

fun v(tag: String, msg: String) = Log.v(tag, msg)

fun d(tag: String, msg: String) = Log.d(tag, msg)

fun i(tag: String, msg: String) = Log.i(tag, msg)

fun w(tag: String, msg: String) = Log.w(tag, msg)

fun e(tag: String, msg: String) = Log.e(tag, msg)

fun wtf(tag: String, msg: String) = Log.wtf(tag, msg)

private val Any.tag: String
    get() = javaClass.simpleName
