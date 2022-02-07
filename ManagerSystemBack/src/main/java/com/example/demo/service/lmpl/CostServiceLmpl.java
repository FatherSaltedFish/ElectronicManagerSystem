package com.example.demo.service.lmpl;

import com.example.demo.model.CostModel;
import com.example.demo.repository.CostMapper;
import com.example.demo.service.CostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("CostService")
public class CostServiceLmpl implements CostService {
    @Resource
    private com.example.demo.repository.CostMapper CostMapper;

    @Override
    public void AddCost(String CostId, String ProjectId, Float CostNumber, Date CostTime, String CostDetail, Integer PictureId) {
        CostMapper.AddCost(CostId,ProjectId,CostNumber,CostTime,CostDetail,PictureId);
    }

    @Override
    public CostModel GetCostByCostId(String CostId) {
        return CostMapper.GetCostByCostId(CostId);
    }

    @Override
    public Float SelectNumberByProjectId(String ProjectId) {
        return CostMapper.SelectNumberByProjectId(ProjectId);
    }

    @Override
    public List<CostModel> GetCostListByProjectId(String ProjectId) {
        return CostMapper.GetCostListByProjectId(ProjectId);
    }

    @Override
    public void ChangeCost(String CostId, String ProjectId, Float CostNumber, Date CostTime, String CostDetail, Integer PictureId) {
        CostMapper.ChangeCost(CostId,ProjectId,CostNumber,CostTime,CostDetail,PictureId);
    }

    @Override
    public void DeleteId(String CostId) {
        CostMapper.DeleteId(CostId);
    }


}
