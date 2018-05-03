package com.cm.presenters


import com.cm.activities.LoginActivity
import com.cm.activities.SplashActivity
import com.dewarder.akommons.startActivity

/**
 * Created by magicwand on 2/19/2018.
 */
class SplashPresenter(val splashActivity: SplashActivity) {


    fun init(): SplashPresenter {
        splashActivity.onHide = { redirectToRelevantActivity() }

        return this
    }

    private fun redirectToRelevantActivity() {
        splashActivity.startActivity<LoginActivity>()
//        val userTableIsEmpty = DbUtility.checkTableEmpty(User::class.java)
//
//        if (!userTableIsEmpty) {
//
//            splashActivity.startActivity<HomeActivity>()
//
//        } else {
//            splashActivity.startActivity<LoginActivity>()
//        }

        splashActivity.finish()


    }

}