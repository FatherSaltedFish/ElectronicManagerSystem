package com.example.demo.service.lmpl;

import com.example.demo.model.InfoModel;
import com.example.demo.service.InfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("InfoService")
public class InfoServiceLmpl implements InfoService {
    @Resource
    private com.example.demo.repository.InfoMapper InfoMapper;

    @Override
    public InfoModel GetInfoByProjectId(String ProjectId){
        return InfoMapper.GetInfoByProjectId(ProjectId);
    }

    @Override
    public void AddInfo(String ProjectId, String ProjectInformation) {
        InfoMapper.AddInfo(ProjectId, ProjectInformation);
    }
}
