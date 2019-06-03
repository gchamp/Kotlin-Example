package com.kotlindemo.utils

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity

class CommonUtils {
    companion object {
        fun setFragment(
            context: FragmentActivity,
            fragment: Fragment,
            tag: String,
            layout: Int,
            removeStack: Boolean
        ) {
            val fragmentManager = context.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            if (removeStack)
                fragmentManager.popBackStackImmediate()
            fragmentTransaction.add(layout, fragment,tag)
            if (fragmentManager.fragments.size>0)
            fragmentTransaction.remove(fragmentManager.fragments.get(fragmentManager.fragments.size-1))
            fragmentTransaction.addToBackStack(tag)
            fragmentTransaction.commit()
        }
    }
}