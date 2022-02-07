package com.example.demo.repository;

import com.example.demo.model.ManagerModel;

import java.util.Date;

public interface ManagerMapper {

    ManagerModel selectByManagerId(String ManagerId);

    void AddManager(ManagerModel ManagerModel);

    ManagerModel GetManageName(String ManagerId);

}
