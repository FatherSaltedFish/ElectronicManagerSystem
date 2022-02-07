package com.example.demo.repository;

import com.example.demo.model.CostModel;
import com.example.demo.model.ProjectModel;

import java.util.Date;
import java.util.List;

public interface CostMapper {

    void AddCost(String CostId, String ProjectId, Float CostNumber, Date CostTime, String CostDetail, Integer PictureId);

    CostModel GetCostByCostId(String CostId);

    Float SelectNumberByProjectId(String ProjectId);

    List<CostModel> GetCostListByProjectId(String ProjectId);

    void ChangeCost(String CostId, String ProjectId, Float CostNumber, Date CostTime, String CostDetail, Integer PictureId);

    void DeleteId(String CostId);
}
