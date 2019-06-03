package com.kotlindemo.base

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlindemo.R
import com.kotlindemo.databinding.FragmentBaseBinding

abstract class BaseFragment : Fragment(){

    private lateinit var mContext: Context
    private lateinit var binding: FragmentBaseBinding

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        this.mContext = context!!
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_base,container,false)
        return binding.root
    }

    fun setLayoutBinding(inflater: LayoutInflater,container: ViewGroup?,layout: Int){
        var view= inflater.inflate(layout,container,false)
        binding.fragmentContainer.addView(view)
    }

    fun getFragmentBinding(): FragmentBaseBinding{
        return binding
    }


}