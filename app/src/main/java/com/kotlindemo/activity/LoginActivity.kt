package com.kotlindemo.activity

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import com.kotlindemo.R
import com.kotlindemo.base.BaseActivity
import com.kotlindemo.utils.AlertUtils
import com.kotlindemo.utils.AppSession
import kotlinx.android.synthetic.main.activity_login.view.*


class LoginActivity : BaseActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContext(this@LoginActivity)
        setSession(this@LoginActivity)
        setLayoutContainer(R.layout.activity_login)
        if (getSession().getBooleanSession(AppSession.IS_REMEMBER)){
            getBinding().flContainer.etUserName.setText(getSession().getStringSession(AppSession.USER_NAME))
            getBinding().flContainer.etPassword.setText(getSession().getStringSession(AppSession.PASSWORD))
            getBinding().flContainer.checkBoxRememberMe.isChecked = true
        }
        getBinding().flContainer.tvLogin.setOnClickListener {
            if (isValidate()){
                if (getBinding().flContainer.checkBoxRememberMe.isChecked){
                    getSession().setStringSession(AppSession.USER_NAME,getBinding().flContainer.etUserName.text.toString().trim())
                    getSession().setStringSession(AppSession.PASSWORD,getBinding().flContainer.etPassword.text.toString().trim())
                    getSession().setBooleanSession(AppSession.IS_REMEMBER,true)
                }else{
                    getSession().setBooleanSession(AppSession.IS_REMEMBER,false)
                }

                postIntent(getContext(),MainActivity::class.java, Bundle(),true)
               getSession().setBooleanSession(AppSession.IS_LOGIN,true)
            }

        }
    }



    fun isValidate():Boolean{

        if (TextUtils.isEmpty(getBinding().flContainer.etUserName.text)){
            AlertUtils.showAlert(mContext,getString(R.string.error_username_msg))
            return false
        }else if (TextUtils.isEmpty(getBinding().flContainer.etPassword.text)){
            AlertUtils.showAlert(mContext,getString(R.string.error_username_msg))
            return false
        }
        return true
    }

    override fun setHeader() {
        getBinding().llFooter.footer.visibility = View.GONE
        getBinding().llHeader.tvHeader.text = getString(R.string.login)
        getBinding().llHeader.flRight.visibility = View.GONE
    }

}