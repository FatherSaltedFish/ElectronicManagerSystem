package com.example.demo.service;

import com.example.demo.model.InfoModel;

public interface InfoService {

    InfoModel GetInfoByProjectId(String ProjectId);

    void AddInfo(String ProjectId,String Information);
}
