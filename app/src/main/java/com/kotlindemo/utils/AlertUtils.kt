package com.kotlindemo.utils

import android.content.Context
import android.support.v7.app.AlertDialog

class AlertUtils {



    companion object{

        fun showAlertWithCallBack(context: Context,type: String,msg : String,callBackListener: CallBackListener){
            val alertDialog = AlertDialog.Builder(context)
            alertDialog.setMessage(msg)
            alertDialog.setCancelable(false)
            alertDialog.setPositiveButton("Yes"){dialog, which ->
                callBackListener.onCallBack(type)
                dialog.dismiss()
            }
            alertDialog.setNegativeButton("No"){dialog, which ->
                dialog.dismiss()
            }
            alertDialog.show()
        }
        fun showAlert(context: Context,msg : String){
            val alertDialog = AlertDialog.Builder(context)
            alertDialog.setCancelable(false)
            alertDialog.setMessage(msg)
            alertDialog.setPositiveButton("Ok"){dialog, which ->
                dialog.dismiss()
            }
            alertDialog.show()
        }

    }

}