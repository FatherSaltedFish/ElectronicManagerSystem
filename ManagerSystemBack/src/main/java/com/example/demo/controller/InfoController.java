package com.example.demo.controller;


import com.example.demo.model.InfoModel;
import com.example.demo.model.ManagerModel;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@CrossOrigin
@Controller
@EnableAutoConfiguration
@RequestMapping(value = {"/Info"})
public class InfoController {

    @Resource
    private com.example.demo.service.InfoService InfoService;

    @ResponseBody
    @RequestMapping(value="/GetInfoByProjectId",produces = "application/json;charset=UTF-8")
    public String GetInfoByProjectId(@RequestParam(value = "ProjectId", required = false) String ProjectId) throws JSONException {
        JSONObject result = new JSONObject();
        InfoModel info=new InfoModel();
        try {
             info= InfoService.GetInfoByProjectId(ProjectId);
        }catch(Exception e){
            result.put("boolean",false);
            return result.toString();
        }
        result.put("boolean",true);
        result.put("info",info.getProjectInfo());
        return result.toString();
    }

    @ResponseBody
    @RequestMapping(value="/AddInfo",produces = "application/json;charset=UTF-8")
    public void AddInfo(@RequestParam(value = "ProjectId", required = false) String ProjectId,
                          @RequestParam(value = "ProjectInfo", required = false) String ProjectInfo) throws JSONException{
        InfoService.AddInfo(ProjectId, ProjectInfo);
    }
}
