package com.example.demo.model;

public class ProjectPeopleModel {
    String ProjectId,PeopleId;
    Boolean ManagerDecide;
    Float Percent;

    public ProjectPeopleModel() {
    }

    public ProjectPeopleModel(String projectId, String peopleId, Boolean managerDecide, Float percent) {
        ProjectId = projectId;
        PeopleId = peopleId;
        ManagerDecide = managerDecide;
        Percent = percent;
    }

    public String getProjectId() {
        return ProjectId;
    }

    public void setProjectId(String projectId) {
        ProjectId = projectId;
    }

    public String getPeopleId() {
        return PeopleId;
    }

    public void setPeopleId(String peopleId) {
        PeopleId = peopleId;
    }

    public Boolean getManagerDecide() {
        return ManagerDecide;
    }

    public void setManagerDecide(Boolean managerDecide) {
        ManagerDecide = managerDecide;
    }

    public Float getPercent() {
        return Percent;
    }

    public void setPercent(Float percent) {
        Percent = percent;
    }
}
