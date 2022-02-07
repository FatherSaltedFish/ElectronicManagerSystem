package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ProjectModel {
    String ProjectId;
    String ProjectName;
    Float ProjectCost;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    Date ProjectTime;
    Float ProjectMoney;
    Boolean ProjectFinish;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    Date ProjectFinishTime;

    public ProjectModel(String projectId, String projectName, Float projectCost, Date projectTime, Float projectMoney, Boolean projectFinish, Date projectFinishTime) {
        ProjectId = projectId;
        ProjectName = projectName;
        ProjectCost = projectCost;
        ProjectTime = projectTime;
        ProjectMoney = projectMoney;
        ProjectFinish = projectFinish;
        ProjectFinishTime = projectFinishTime;
    }

    public ProjectModel() {
        super();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getProjectId() {
        return ProjectId;
    }

    public void setProjectId(String projectId) {
        ProjectId = projectId;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }

    public Float getProjectCost() {
        return ProjectCost;
    }

    public void setProjectCost(Float projectCost) {
        ProjectCost = projectCost;
    }

    public Date getProjectTime() {
        return ProjectTime;
    }

    public void setProjectTime(Date ProjectTime) {
        ProjectTime = ProjectTime;
    }

    public Float getProjectMoney() {
        return ProjectMoney;
    }

    public void setProjectMoney(Float projectMoney) {
        ProjectMoney = projectMoney;
    }



    public Boolean getProjectFinish() {
        return ProjectFinish;
    }

    public void setProjectFinish(Boolean projectFinish) {
        ProjectFinish = projectFinish;
    }

    public Date getProjectFinishTime() {
        return ProjectFinishTime;
    }

    public void setProjectFinishTime(Date projectFinishTime) {
        ProjectFinishTime = projectFinishTime;
    }

    @Override
    public String toString() {
        return "ProjectModel{" +
                "ProjectId='" + ProjectId + '\'' +
                ", ProjectName='" + ProjectName + '\'' +
                ", ProjectCost=" + ProjectCost +
                ", ProjectTime=" + ProjectTime +
                ", ProjectMoney=" + ProjectMoney +
                ", ProjectFinish=" + ProjectFinish +
                ", ProjectFinishTime=" + ProjectFinishTime +
                '}';
    }
}
