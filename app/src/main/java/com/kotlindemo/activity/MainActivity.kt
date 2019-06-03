package com.kotlindemo.activity

import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.view.View
import android.widget.Toast
import com.kotlindemo.R
import com.kotlindemo.base.BaseActivity
import com.kotlindemo.fragment.*
import com.kotlindemo.utils.*

class MainActivity : BaseActivity(),CallBackListener{


    private var isExit = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContext(this@MainActivity)
        setSession(this@MainActivity)
        setLayoutContainer(R.layout.activity_dashboard)
        setListener()
        CommonUtils.setFragment(this@MainActivity,DashboardFragment.getInstance(this),DashboardFragment::class.java.simpleName.toString(),R.id.dashboard_layout,false)

    }

    override fun setHeader() {
        getBinding().llHeader.tvHeader.text = getString(R.string.assigned_project)
        getBinding().llFooter.footer.visibility = View.GONE
        getBinding().llHeader.flRight.visibility = View.VISIBLE
        getBinding().llHeader.ivRight.visibility = View.VISIBLE
        getBinding().llHeader.tvRight.visibility = View.GONE
    }

    fun setListener(){

        getBinding().llHeader.ivRight.setOnClickListener {
            AlertUtils.showAlertWithCallBack(getContext(),AppConstant.CALLBACK_LOGOUT,getString(R.string.logout_confirmation_msg),this)
        }



    }

    override fun onCallBack(type : String) {
        when(type) {
            AppConstant.CALLBACK_LOGOUT ->{
                postIntent(getContext(), LoginActivity::class.java, Bundle(), true)
                getSession().setBooleanSession(AppSession.IS_LOGIN, false)
                getBinding().llFooter.footer.visibility = View.GONE
            }



        }
    }




}