package com.example.demo.controller;


import com.example.demo.model.PeopleModel;
import com.example.demo.service.ProjectService;
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

@CrossOrigin
@Controller
@EnableAutoConfiguration
@RequestMapping(value = {"/People"})
public class PeoPleController {

    @Resource
    private com.example.demo.service.PeopleService PeopleService;

    @ResponseBody
    @RequestMapping(value = "/GetAllPeople",produces = "application/json;charset=UTF-8")
    public String GetAllPeople() throws JSONException, JsonProcessingException {
        JSONObject result=new JSONObject();
        result.put("boolean",true);
        //result.put("ProjectList",new SimpleDateFormat().parse(ProjectService.GetAllProject()));
        result.put("PeopleList",new ObjectMapper().writeValueAsString(PeopleService.GetAllPeople()));
        return result.toString();
    }


    @ResponseBody
    @RequestMapping(value = "/AddPeople",produces = "application/json;charset=UTF-8")
    public String AddPeople(@RequestParam(value="PeopleId")String PeopleId,
                            @RequestParam(value="PeopleName")String PeopleName,
                            @RequestParam(value="Email")String Email) throws JSONException {
        JSONObject result=new JSONObject();
        try {
            PeopleService.AddPeople(PeopleId,PeopleName,Email);
            }catch(Exception e){
            result.put("boolean",false);
            result.put("wrong",e);
            return result.toString();
        }
        result.put("boolean",true);
        return result.toString();
    }

    @ResponseBody
    @RequestMapping(value = "/DeletePeople",produces = "application/json;charset=UTF-8")
    public String DeletePeople(@RequestParam(value="PeopleId")String PeopleId) throws JSONException {
        JSONObject result=new JSONObject();
        try{
            PeopleService.DeletePeople(PeopleId);
        }catch(Exception e){
            result.put("boolean",false);
            result.put("wrong",e);
            return result.toString();
        }
        result.put("boolean",true);
        return result.toString();
    }


    @ResponseBody
    @RequestMapping(value ="GetPeopleByPeopleId",produces = "application/json;charset=UTF-8")
    public String GetPeopleByPeopleId(@RequestParam(value = "PeopleId")String PeopleId) throws JSONException {
        JSONObject result=new JSONObject();
        PeopleModel people=new PeopleModel();
        try{
            people=PeopleService.GetPeopleByPeopleId(PeopleId);
        }catch(Exception e){
            result.put("boolean",false);
            result.put("wrong",e);
            return result.toString();
        }
        if(people!=null) {
            result.put("boolean", false);
            result.put("wrong", "员工编号已有，请重试");
            return result.toString();
        }
        else
            result.put("boolean",true);
        return result.toString();
    }

}
