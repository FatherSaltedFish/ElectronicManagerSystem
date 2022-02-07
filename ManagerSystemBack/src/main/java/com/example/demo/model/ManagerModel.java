package com.example.demo.model;

import java.util.Objects;

public class ManagerModel {
    String ManagerId;
    String ManagerPassword;
    String Manager_Name;

    public String getManagerId() {
        return ManagerId;
    }

    public String getManagerPassword() {
        return ManagerPassword;
    }

    public String getManager_Name() {
        return Manager_Name;
    }

    public void setManager_Name(String manager_Name) {
        Manager_Name = manager_Name;
    }

    public void setManagerId(String managerId) {
        ManagerId = managerId;
    }

    public void setManagerPassword(String managerPassword) {
        ManagerPassword = managerPassword;
    }

    public ManagerModel(){}

    public ManagerModel(String ManagerId,String ManagerPassword,String Manager_Name){
        this.ManagerId=ManagerId;
        this.ManagerPassword=ManagerPassword;
        this.Manager_Name=Manager_Name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManagerModel that = (ManagerModel) o;
        return Objects.equals(ManagerId, that.ManagerId) &&
                Objects.equals(ManagerPassword, that.ManagerPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ManagerId, ManagerPassword);
    }

    @Override
    public String toString() {
        return "ManagerModel{" +
                "ManagerId=" + ManagerId +
                ", ManagerPassword='" + ManagerPassword + '\'' +
                ", Manager_Name='" + Manager_Name + '\'' +
                '}';
    }
}
