package com.example.demo.service.lmpl;


import com.example.demo.model.ManagerModel;
import com.example.demo.repository.ManagerMapper;
import org.springframework.stereotype.Service;

import com.example.demo.model.*;
import com.example.demo.service.*;
import javax.annotation.Resource;
import com.example.demo.repository.*;

import java.util.Date;


@Service("ManagerService")
public class ManagerServiceLmpl implements ManagerService{
    @Resource
    private ManagerMapper ManagerMapper;

    @Override
    public ManagerModel selectByManagerId(String ManagerId)
    {
        return ManagerMapper.selectByManagerId(ManagerId);
    }


    @Override
    public void AddManager(ManagerModel ManagerModel) {
        ManagerMapper.AddManager(ManagerModel);

    }

    @Override
    public  ManagerModel GetManageName(String ManagerId){
        return ManagerMapper.GetManageName(ManagerId);
    }




}
