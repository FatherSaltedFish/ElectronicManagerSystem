package com.example.demo.repository;

import com.example.demo.model.InfoModel;

public interface InfoMapper {

    InfoModel GetInfoByProjectId(String ProjectId);

    void AddInfo(String ProjectId,String ProjectInformation);
}
