package com.example.demo.controller;


import com.example.demo.model.ProjectModel;
import com.example.demo.service.InfoService;
import com.example.demo.service.ManagerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@CrossOrigin
@Controller
@EnableAutoConfiguration
@RequestMapping(value = {"/Project"})
public class ProjectController {
    @Resource
    private com.example.demo.service.ProjectService ProjectService;

    @Resource
    private com.example.demo.service.InfoService InfoService;

    @ResponseBody
    @RequestMapping(value = "/GetAllProject",produces = "application/json;charset=UTF-8")
    public String GetAllMapping() throws JSONException, JsonProcessingException {
        //System.out.println(ProjectService.GetAllProject());
        JSONObject result=new JSONObject();
        result.put("boolean",true);
        //result.put("ProjectList",new SimpleDateFormat().parse(ProjectService.GetAllProject()));
        result.put("ProjectList",new ObjectMapper().writeValueAsString(ProjectService.GetAllProject()));
        return result.toString();
    }


    @ResponseBody
    @RequestMapping(value = "/FinishProject",produces = "application/json;charset=UTF-8")
    public void FinishProject(@RequestParam(value = "ProjectId", required = false) String ProjectId){
        ProjectService.FinishProject(ProjectId,new Date());
    }

    @ResponseBody
    @RequestMapping(value = "/CreateProject")
    public String CreateProject(@RequestParam(value = "ProjectId",required = false)String ProjectId,
                              @RequestParam(value = "ProjectName",required = false)String ProjectName,
                              @RequestParam(value = "ProjectMoney",required = false)String ProjectMoney,
                              @RequestParam(value = "ProjectTime",required = false)Date ProjectTime,
                              @RequestParam(value = "ProjectInfo",required = false)String ProjectInfo) throws JSONException {

        JSONObject result=new JSONObject();
        try {
            ProjectService.CreateProject(ProjectId, ProjectName, ProjectTime, Float.valueOf(ProjectMoney));
            InfoService.AddInfo(ProjectId, ProjectInfo);
        }catch (Exception e){
            result.put("boolean",false);
            return result.toString();
        }
        result.put("boolean",true);
        return result.toString();
    }


    @ResponseBody
    @RequestMapping(value = "/GetProjectByProjectId",produces = "application/json;charset=UTF-8")
    public String GetProjectByProjectId(@RequestParam(value = "ProjectId",required = false)String ProjectId) throws JSONException {
        JSONObject result = new JSONObject();
        ProjectModel Project = ProjectService.GetProjectByProjectId(ProjectId);
        if(Project == null)
            result.put("boolean",true);
        else {
            result.put("boolean", false);
            result.put("Project", Project);
        }
        return  result.toString();
    }


    @ResponseBody
    @RequestMapping(value = "/GetMoneyByProjectId",produces = "application/json;charset=UTF-8")
    public String GetMoneyByProjectId(@RequestParam(value = "ProjectId",required = false)String ProjectId) throws JSONException {
        JSONObject result = new JSONObject();
        ProjectModel Project = ProjectService.GetProjectByProjectId(ProjectId);
        if(Project == null)
            result.put("boolean",true);
        else {
            result.put("boolean", false);
            result.put("Number", Project.getProjectMoney()-Project.getProjectCost());
        }
        return  result.toString();
    }


    @ResponseBody
    @RequestMapping(value = "/GetProfit",produces = "application/json;charset=UTF-8")
    public String GetProfit() throws JSONException {
        JSONObject result = new JSONObject();
        try {
            List<ProjectModel> ProjectList = ProjectService.GetAllProject();
            Float Cost = new Float(0);
            Float All = new Float(0);
            for (ProjectModel item : ProjectList) {
                Cost += item.getProjectCost();
                All += item.getProjectMoney();
            }
            result.put("boolean",true);
            result.put("Profit",All-Cost);
            result.put("ProfitRat",((All-Cost)/Cost)*100);
            return result.toString();
        }catch(Exception e){
            result.put("boolean",false);
            return result.toString();
        }
    }

    @ResponseBody
    @RequestMapping(value ="DeleteProcess",produces = "application/json;charset=UTF-8")
    public String DeleteProcess(@RequestParam(value = "ProjectId",required = false)String ProjectId) throws JSONException {
        JSONObject result = new JSONObject();
        try {
            ProjectService.DeleteProcess(ProjectId);
            result.put("boolean", true);
        }
        catch(Exception e) {
            result.put("boolean", false);
            System.out.println(e);
            result.put("wrong", e);
        }
        return  result.toString();
    }

}
