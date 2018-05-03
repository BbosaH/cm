package com.cm.activities

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View

import com.cm.R
import com.cm.database.Dao
import com.cm.presenters.LoginPresenter
import com.dewarder.akommons.startActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var  onLogin : (uname:String,password:String)->Unit;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Dao.insertUser();
        val facility1 =Dao.inserFacility("1","Rom Mbuya","mbuya");
        val facility2 =Dao.inserFacility("2","Rom Bugolobi","Bugo")
        Dao.insertCddpPoint("1","Rom Clinic",facility1)
        Dao.insertCddpPoint("2","Bugolobi Clinic",facility2);
        Dao.insertCddpPoint("3","Rom Kinawa",facility1);
        Dao.insertCddpPoint("4","Bugolobi Hc",facility2);

        LoginPresenter(this).init()
        btn_sign_in_button.setOnClickListener{
            //startActivity<FormScreenGeneral>()
            onLogin(txt_uname.text.toString(),txt_password.text.toString())
        }
    }


    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    fun showProgress(show: Boolean) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        val btnLogin = btn_sign_in_button
        val mProgressView = login_progress
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {

            val shortAnimTime = resources.getInteger(android.R.integer.config_shortAnimTime)

            btnLogin!!.visibility = if (show) View.GONE else View.VISIBLE
            btnLogin!!.animate()
                    .setDuration(shortAnimTime.toLong())
                    .alpha((if (show) 0 else 1).toFloat())
                    .setListener(object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator) {
                            btnLogin!!.visibility = if (show) View.GONE else View.VISIBLE
                        }
                    })


            mProgressView!!.visibility = if (show) View.VISIBLE else View.GONE
            mProgressView!!.animate()
                    .setDuration(shortAnimTime.toLong())
                    .alpha((if (show) 1 else 0).toFloat())
                    .setListener(object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator) {
                            mProgressView!!.visibility = if (show) View.VISIBLE else View.GONE
                        }
                    })
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView!!.visibility = if (show) View.VISIBLE else View.GONE
            btnLogin!!.visibility = if (show) View.GONE else View.VISIBLE
        }
    }


}
