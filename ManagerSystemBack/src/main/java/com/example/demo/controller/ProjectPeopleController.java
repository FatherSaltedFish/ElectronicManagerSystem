package com.example.demo.controller;


import com.example.demo.model.PeopleModel;
import com.example.demo.model.PeopleShowModel;
import com.example.demo.model.ProjectPeopleModel;
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
import java.util.ArrayList;
import java.util.List;


@CrossOrigin
@Controller
@EnableAutoConfiguration
@RequestMapping(value = {"/ProjectPeople"})
public class ProjectPeopleController {

    @Resource
    private com.example.demo.service.ProjectPeopleService ProjectPeopleService;

    @Resource
    private com.example.demo.service.PeopleService PeopleService;


    @ResponseBody
    @RequestMapping(value="/GetPeopleByProjectId",produces = "application/json;charset=UTF-8")
    public String GetPeopleByProjectId(@RequestParam(value = "ProjectId")String ProjectId) throws JSONException {
        JSONObject result=new JSONObject();
        try{
            List<PeopleShowModel> PeopleShowList=new ArrayList<PeopleShowModel>();
            PeopleModel people=new PeopleModel();
            List<ProjectPeopleModel> ProjectPeopleModelList= ProjectPeopleService.GetAllProjectPeopleByProjectId(ProjectId);
            for(ProjectPeopleModel item:ProjectPeopleModelList){
                people=PeopleService.GetPeopleByPeopleId(item.getPeopleId());
                PeopleShowModel p=new PeopleShowModel(people.getPeopleId(),people.getPeopleName(),item.getManagerDecide(),item.getPercent());
                PeopleShowList.add(p);
            }
            result.put("boolean",true);
            result.put("PeopleList",new ObjectMapper().writeValueAsString(PeopleShowList));
        }catch(Exception e){
            result.put("boolean",false);
            result.put("wrong",e);
            return result.toString();
        }
        return result.toString();
    }


    @ResponseBody
    @RequestMapping(value="/AddProjectPeople",produces = "application/json;charset=UTF-8")
    public String AddProjectPeople(@RequestParam(value = "ProjectId")String ProjectId,
                                   @RequestParam(value = "PeopleId")String PeopleId,
                                   @RequestParam(value = "ManagerDecide")Boolean ManagerDecide,
                                   @RequestParam(value = "Percent")String Percent) throws JSONException {
        JSONObject result=new JSONObject();
        try{
            ProjectPeopleService.AddProjectPeople(ProjectId,PeopleId,false,new Float(0));
        }catch(Exception e){
            result.put("boolean",false);
            result.put("wrong",e);
            System.out.println(e);
            return result.toString();
        }
        result.put("boolean",true);
        return result.toString();
    }


    @ResponseBody
    @RequestMapping(value="/DeleteProjectPeople",produces = "application/json;charset=UTF-8")
    public String DeleteProjectPeople(@RequestParam(value = "ProjectId")String ProjectId,
                                   @RequestParam(value = "PeopleId")String PeopleId) throws JSONException {
        JSONObject result=new JSONObject();
        ProjectPeopleModel PPM=new ProjectPeopleModel();
        try{
            PPM =ProjectPeopleService.GetProjectPeopleByProjectIdPeopleId(ProjectId, PeopleId);
            ProjectPeopleService.DeleteProjectPeople(ProjectId,PeopleId);
            if(PPM.getPercent()==0){

            }else{
                List<ProjectPeopleModel> ProjectPeopleModelList= ProjectPeopleService.GetAllProjectPeopleByProjectId(ProjectId);
                int len=0;
                for(ProjectPeopleModel p:ProjectPeopleModelList) {
                    len+=1;
                }
                for(ProjectPeopleModel p:ProjectPeopleModelList){
                    ProjectPeopleService.UpdateProjectPeople(p.getProjectId(),p.getPeopleId(),p.getPercent()+PPM.getPercent()/len);
                }
            }
        }catch(Exception e){
            System.out.println(e);
            result.put("boolean",false);
            result.put("wrong",e);
            return result.toString();
        }
        result.put("boolean",true);
        return result.toString();
    }


    @ResponseBody
    @RequestMapping(value="/UpdateProjectPeople",produces = "application/json;charset=UTF-8")
    public String UpdateProjectPeople(@RequestParam(value = "ProjectId")String ProjectId,
                                   @RequestParam(value = "PeopleId")String PeopleId,
                                   @RequestParam(value = "Percent")String Percent) throws JSONException {
        JSONObject result=new JSONObject();
        try{
            ProjectPeopleService.UpdateProjectPeople(ProjectId,PeopleId,Float.valueOf(Percent));
        }catch(Exception e){
            result.put("boolean",false);
            result.put("wrong",e);
            return result.toString();
        }
        result.put("boolean",true);
        return result.toString();
    }


    @ResponseBody
    @RequestMapping(value="/ChangeMaster",produces = "application/json;charset=UTF-8")
    public String ChangeMaster(@RequestParam(value = "ProjectId")String ProjectId,
                                      @RequestParam(value = "PeopleId")String PeopleId) throws JSONException {
        JSONObject result=new JSONObject();
        try{
            System.out.println(ProjectId);
            ProjectPeopleService.DeleteMaster(ProjectId);
            ProjectPeopleService.SetMaster(ProjectId,PeopleId);
        }catch(Exception e){
            result.put("boolean",false);
            result.put("wrong",e);
            System.out.println(e);
            return result.toString();
        }
        result.put("boolean",true);
        return result.toString();
    }


}
