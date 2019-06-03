package com.kotlindemo.model

class AppModel{

    private lateinit var projectName:String
    private lateinit var projectId:String
    private lateinit var startDate:String
    private lateinit var endDate:String

    fun setProjectName(projectName:String){
        this.projectName = projectName
    }

    fun getProjectName():String{
        return projectName
    }

    fun setProjectId(projectId : String){
        this.projectId = projectId
    }

    fun getProjectId(): String{
        return projectId
    }

    fun setStartDate(startDate : String){
        this.startDate = startDate
    }

    fun getStartDate(): String{
        return startDate
    }

    fun setEndDate(endDate : String){
        this.endDate = endDate
    }

    fun getEndDate(): String{
        return endDate
    }



}