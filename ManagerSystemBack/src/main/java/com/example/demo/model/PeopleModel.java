package com.example.demo.model;

public class PeopleModel {
    String PeopleId,PeopleName,Email;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public PeopleModel(String peopleId, String peopleName, String email) {
        PeopleId = peopleId;
        PeopleName = peopleName;
        Email = email;
    }

    public PeopleModel() {
    }

    public PeopleModel(String peopleId, String peopleName) {
        PeopleId = peopleId;
        PeopleName = peopleName;
    }

    public String getPeopleId() {
        return PeopleId;
    }

    public void setPeopleId(String peopleId) {
        PeopleId = peopleId;
    }

    public String getPeopleName() {
        return PeopleName;
    }

    public void setPeopleName(String peopleName) {
        PeopleName = peopleName;
    }
}
