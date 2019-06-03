package com.kotlindemo.base

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.view.LayoutInflater
import com.kotlindemo.R
import com.kotlindemo.databinding.ActivityBaseBinding
import com.kotlindemo.utils.AppConstant
import com.kotlindemo.utils.AppSession

abstract class BaseActivity : FragmentActivity(){

    lateinit var mBinding : ActivityBaseBinding
    lateinit var mContext: Context
    lateinit var appSession: AppSession

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_base)
    }


    fun setSession(context: Context){
        this.appSession = AppSession(context)
    }

    fun getSession() : AppSession{
        return appSession
    }

    fun setContext(context: Context){
        this.mContext= context
    }

    fun getContext():Context{
        return mContext
    }

    fun getBinding(): ActivityBaseBinding{
        return mBinding
    }

    fun setLayoutContainer(layout : Int){
        var viewGroup = LayoutInflater.from(mContext).inflate(layout,null)
        mBinding.flContainer.addView(viewGroup)
        setHeader()
    }

    fun postIntent(mContext: Context, activity: Class<*>, bundle: Bundle,isNewTask : Boolean){
        val intent = Intent(mContext,activity)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        if (isNewTask) {
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        intent.putExtra(AppConstant.BUNDLE_DATA,bundle)
        startActivity(intent)
    }

    abstract fun setHeader()


}