package com.kotlindemo.fragment

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlindemo.R
import com.kotlindemo.adapter.DashboardAdapter
import com.kotlindemo.databinding.FragmentDashboardBinding
import com.kotlindemo.model.AppModel
import com.kotlindemo.utils.AppConstant
import com.kotlindemo.utils.CallBackListener

class DashboardFragment : Fragment(),View.OnClickListener{

    private lateinit var mContext: Context
    private lateinit var binding : FragmentDashboardBinding

    companion object {
        lateinit var listener: CallBackListener
        fun getInstance(listener: CallBackListener): DashboardFragment {
            this.listener = listener
            var dashboardFragment = DashboardFragment()
            var bundle = Bundle()
//        bundle.putString()
            dashboardFragment.arguments = bundle
            return dashboardFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        this.mContext = context!!
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_dashboard,container,false)
        setUpRecyclerView()
        return binding.root
    }

    fun setUpRecyclerView(){
        var names = arrayOf("Project1","Project2","Project3")
        var startdate = arrayOf("1/1/2000","1/1/2000","1/1/2000")
        var enddate = arrayOf("1/1/2035","1/1/2035","1/1/2035")
        var count=0
        var list = ArrayList<AppModel>()
        for (name in names){
            count++
            var appModel  = AppModel()
            appModel.setProjectName(name)
            appModel.setProjectId(""+count)
            appModel.setStartDate(startdate[count-1])
            appModel.setEndDate(enddate[count-1])
            list.add(appModel)
        }
        binding.llRecycler.rvMain.layoutManager = LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false)
        binding.llRecycler.rvMain.adapter = DashboardAdapter(mContext,list,this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.ll_root ->
                listener.onCallBack(AppConstant.CALLBACK_FRAGMENT_REPORT_TYPE)
        }
    }


}