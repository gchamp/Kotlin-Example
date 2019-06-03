package com.kotlindemo.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlindemo.R
import com.kotlindemo.databinding.RowDashboardBinding
import com.kotlindemo.model.AppModel

class DashboardAdapter( context : Context,list : List<AppModel>,listener: View.OnClickListener) : RecyclerView.Adapter<DashboardAdapter.ViewHolder>(){

    var mContext = context
    var list = list
    var listener = listener

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.row_dashboard,p0,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.binding?.tvProject?.text = list.get(p1).getProjectName()
        p0.binding?.tvStartDate?.text = "Start Date: "+list.get(p1).getStartDate()
        p0.binding?.tvEndDate?.text = "End Date: "+list.get(p1).getEndDate()

        p0.binding?.llRoot?.setOnClickListener {
            listener.onClick(p0.binding?.llRoot)
        }

    }


    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var binding= DataBindingUtil.bind<RowDashboardBinding>(itemView)
    }

}