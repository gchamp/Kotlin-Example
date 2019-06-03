package com.kotlindemo.utils

import android.content.Context

class AppSession(context: Context) {
    var SHAREDPRE_NAME = "shared_pre"
    var sharedPreferences = context.getSharedPreferences(SHAREDPRE_NAME,Context.MODE_PRIVATE)
    var editor = sharedPreferences.edit()

    companion object{
        val USER_NAME="user_name"
        val PASSWORD="password"
        val IS_REMEMBER="is_remember"
        var IS_LOGIN="is_login"
    }

    fun setBooleanSession(name: String , value: Boolean){
        editor.putBoolean(name,value)
        editor.apply()
    }

    fun getBooleanSession(name: String) : Boolean{
        return sharedPreferences.getBoolean(name,false)
    }

    fun setStringSession(name: String,value: String){
        editor.putString(name,value)
        editor.apply()
    }

    fun getStringSession(name: String) : String{
        return sharedPreferences.getString(name,null)
    }


    fun setIntSession(name: String,value: Int){
        editor.putInt(name,value)
        editor.apply()
    }

    fun getIntSession(name: String): Int{
        return sharedPreferences.getInt(name,0)
    }

    fun setFloatSession(name: String,value: Float){
        editor.putFloat(name,value)
        editor.apply()
    }

    fun getFloatSession(name: String) : Float{
        return sharedPreferences.getFloat(name,0f)
    }


}