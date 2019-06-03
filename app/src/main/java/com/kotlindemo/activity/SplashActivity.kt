package com.kotlindemo.activity

import android.os.Bundle
import android.os.Handler
import android.view.View
import com.kotlindemo.R
import com.kotlindemo.base.BaseActivity
import com.kotlindemo.utils.AppSession

class SplashActivity : BaseActivity() {

    private var mRunnable = Runnable {
        if (getSession().getBooleanSession(AppSession.IS_LOGIN)){
        postIntent(getContext(),MainActivity::class.java,Bundle(),true)
        getSession().setBooleanSession(AppSession.IS_LOGIN,true)
        }else{
            postIntent(getContext(),LoginActivity::class.java,Bundle(),true)
        }
    }

    private lateinit var mHandler : Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContext(this@SplashActivity)
        setSession(this@SplashActivity)
        setLayoutContainer(R.layout.activity_splash)
        mHandler = Handler()
        mHandler.postDelayed(mRunnable,2000)
    }



    override fun onDestroy() {
        super.onDestroy()
        mHandler.removeCallbacks(mRunnable)
    }

    override fun setHeader() {
        getBinding().llHeader.header.visibility = View.GONE
        getBinding().llFooter.footer.visibility = View.GONE

    }


}
