package com.cm.presenters

import android.content.Intent
import android.net.Uri
import com.cm.Utilities.longToast
import com.cm.activities.FormScreenGeneral
import com.cm.activities.LoginActivity
import com.cm.connection.Connection
import com.cm.database.User
import com.dewarder.akommons.startActivity
import com.omnitech.elunda.proto.ClientRequest
import com.omnitech.elunda.proto.ServerResponse
import kotlinx.android.synthetic.main.activity_login.*

/**
 * Created by magicwand on 2/19/2018.
 */
class LoginPresenter(private val loginActivity: LoginActivity) {

    fun init(){

        loginActivity.onLogin = { uname:String,pass:String->
            doLogin(uname,pass)
        }

    }

    private fun doLogin(uname:String,pass:String) {

        User.getCurrentUser { user->

            if(user !=null){
                if (uname.isBlank() || pass.isBlank()) {
                    loginActivity.longToast("Please Enter UserName and Password");
                }
                else{
                    if(uname==user.userName && pass ==user.password){
                        loginActivity.finish()
                        loginActivity.startActivity<FormScreenGeneral>()
                    }else{
                        loginActivity.longToast("Please Enter correct credentials")
                    }
                }
            }else{

                connectToLogin(uname,pass);

            }

        }





    }
    private fun connectToLogin(username:String,password:String){

                        val loginRequest = ClientRequest.Builder()
                        .request(ClientRequest.RequestType.AUTHENTICATE)
                        .username(username)
                        .password(password)
                        .build()

                loginActivity.showProgress(true)

                Connection.postDataAsync(
                        loginRequest,
                        onSuccess = {
                            onLoginSuccessFull(it, username, password)
                        },
                        onError = {
                            loginActivity.longToast(it)
                            loginActivity.runOnUiThread { loginActivity.showProgress(false) }
                        }
                )

    }

    private fun onLoginSuccessFull(serverResponse: ServerResponse,
                                   username: String,
                                   pPassword: String) {


//         val user = serverResponse.user.toUser(username, pPassword).also { user -> user.farm = farm }
//         user.save()
//         loginActivity.finish()
//         loginActivity.startActivity<HomeActivity>()

    }




}