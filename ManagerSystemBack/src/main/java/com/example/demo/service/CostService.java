package com.example.demo.service;

import com.example.demo.model.CostModel;

import java.util.Date;
import java.util.List;

public interface CostService {

    void AddCost(String CostId, String projectId, Float costNumber, Date costTime, String costDetail, Integer pictureId);

    CostModel GetCostByCostId(String CostId);

    Float SelectNumberByProjectId(String ProjectId);

    List<CostModel> GetCostListByProjectId(String ProjectId);

    void ChangeCost(String CostId, String ProjectId, Float CostNumber, Date CostTime, String CostDetail, Integer PictureId);

    void DeleteId(String CostId);

}
