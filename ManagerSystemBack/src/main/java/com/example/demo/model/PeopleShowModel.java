package com.example.demo.model;

public class PeopleShowModel {
    String PeopleId,PeopleName;
    Boolean ManagerDecide;
    Float Per;

    public String getPeopleId() {
        return PeopleId;
    }

    public void setPeopleId(String peopleId) {
        PeopleId = peopleId;
    }

    public PeopleShowModel() {
    }

    public PeopleShowModel(String peopleId, String peopleName, Boolean managerDecide, Float percent) {
        PeopleId = peopleId;
        PeopleName = peopleName;
        ManagerDecide = managerDecide;
        Per = percent;
    }

    @Override
    public String toString() {
        return "PeopleShowModel{" +
                "PeopleId='" + PeopleId + '\'' +
                ", PeopleName='" + PeopleName + '\'' +
                ", ManagerDecide=" + ManagerDecide +
                ", Percent=" + Per +
                '}';
    }

    public String getPeopleName() {
        return PeopleName;
    }

    public void setPeopleName(String peopleName) {
        PeopleName = peopleName;
    }

    public Boolean getManagerDecide() {
        return ManagerDecide;
    }

    public void setManagerDecide(Boolean managerDecide) {
        ManagerDecide = managerDecide;
    }

    public Float getPercent() {
        return Per;
    }

    public void setPercent(Float percent) {
        Per = percent;
    }
}
