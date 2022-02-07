package com.example.demo.model;

public class InfoModel {
    String ProjectI,ProjectInfo;

    public InfoModel() {
    }

    public InfoModel(String projectI, String projectInfo) {
        ProjectI = projectI;
        ProjectInfo = projectInfo;
    }

    public String getProjectI() {
        return ProjectI;
    }

    public void setProjectI(String projectI) {
        ProjectI = projectI;
    }

    public String getProjectInfo() {
        return ProjectInfo;
    }

    public void setProjectInfo(String projectInfo) {
        ProjectInfo = projectInfo;
    }
}
