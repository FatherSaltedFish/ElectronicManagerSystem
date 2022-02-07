package com.example.demo.service;

import com.example.demo.model.ManagerModel;

public interface ManagerService {

    public ManagerModel selectByManagerId(String ManagerId);

    public void AddManager(ManagerModel ManagerModel);

    public ManagerModel GetManageName(String ManagerId);
}
