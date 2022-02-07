package com.example.demo.controller;

import com.example.demo.model.CostModel;
import com.example.demo.service.ProjectService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

@CrossOrigin
@Controller
@EnableAutoConfiguration
@RequestMapping(value = {"/Cost"})
public class CostController {

    @Resource
    private com.example.demo.service.CostService CostService;

    @Resource
    private com.example.demo.service.ProjectService ProjcetService;


    @ResponseBody
    @RequestMapping(value="/AddCost",produces = "application/json;charset=UTF-8")
    public String AddCost(@RequestParam(value="CostId")String CostId,
                        @RequestParam(value="ProjectId")String ProjectId,
                        @RequestParam(value="CostNumber")String CostNumber,
                        @RequestParam(value="CostTime") Date CostTime,
                        @RequestParam(value="CostDetail")String CostDetail,
                        @RequestParam(value="PictureId")String PictureId) throws JSONException {
        JSONObject result = new JSONObject();
        try {
            //修改Cost
            CostService.AddCost(CostId, ProjectId, Float.valueOf(CostNumber), CostTime, CostDetail, Integer.valueOf(PictureId));
            //修改项目花销
            Float number = CostService.SelectNumberByProjectId(ProjectId);
            ProjcetService.UpdateProjectCostByProjectId(number, ProjectId);
            result.put("boolean",true);
            return result.toString();
        }catch(Exception e)
        {
            result.put("boolean",false);
            return result.toString();
        }
    }

    @ResponseBody
    @RequestMapping(value="/ChangeCost",produces = "application/json;charset=UTF-8")
    public String ChangeCost(@RequestParam(value="CostId")String CostId,
                        @RequestParam(value="ProjectId")String ProjectId,
                        @RequestParam(value="CostNumber")Float CostNumber,
                        @RequestParam(value="CostTime") Date CostTime,
                        @RequestParam(value="CostDetail")String CostDetail,
                        @RequestParam(value="PictureId")String PictureId) throws JSONException {

        JSONObject result = new JSONObject();
        try {
            //修改Cost
            CostService.ChangeCost(CostId, ProjectId, CostNumber, CostTime, CostDetail, Integer.valueOf(PictureId));
            //修改项目花销
            Float number = CostService.SelectNumberByProjectId(ProjectId);
            ProjcetService.UpdateProjectCostByProjectId(number, ProjectId);
            result.put("boolean",true);
            return result.toString();
        }catch(Exception e)
        {
            result.put("boolean",false);
            return result.toString();
        }
    }



    @ResponseBody
    @RequestMapping(value = "/GetCostByCostId")
    public String GetCostByCostId(@RequestParam(value="CostId")String CostId) throws JSONException {
        JSONObject result = new JSONObject();
        CostModel Cost = CostService.GetCostByCostId(CostId);
        if(Cost == null)
            result.put("boolean",true);
        else {
            result.put("boolean", false);
//            result.put("Cost", Cost);
            result.put("PictureId",Cost.getPictureId());
            result.put("CostNumber",Cost.getCostNumber());
            result.put("CostTime",Cost.getCostTime());
            result.put("CostDetail",Cost.getCostDetail());
            result.put("ProjectId",Cost.getProjectId());
        }
        return  result.toString();
    }

    @ResponseBody
    @RequestMapping(value = "/GetCostListByProjectId",produces = "application/json;charset=UTF-8")
    public String GetCostListByProjectId(@RequestParam(value="ProjectId") String ProjectId) throws JSONException, JsonProcessingException {
        JSONObject result=new JSONObject();
        try{
            result.put("CostList",new ObjectMapper().writeValueAsString(CostService.GetCostListByProjectId(ProjectId)));
            result.put("boolean",true);
            return result.toString();
        }catch(Exception e){
            result.put("boolean",false);
        }
        return result.toString();
    }

    @ResponseBody
    @RequestMapping(value = "/DeleteCost",produces = "application/json;charset=UTF-8")
    public String DeleteCost(@RequestParam(value="CostId") String CostId) throws JSONException, JsonProcessingException {
        JSONObject result=new JSONObject();
        try{
            CostModel Cost = CostService.GetCostByCostId(CostId);
            CostService.DeleteId(CostId);
            //修改项目花销
            Float number = CostService.SelectNumberByProjectId(Cost.getProjectId());
            System.out.println(number);
            if(number == null)
                number=Float.valueOf(0);
            ProjcetService.UpdateProjectCostByProjectId(number, Cost.getProjectId());
            result.put("boolean",true);
            return result.toString();
        }catch(Exception e){
            result.put("boolean",false);
            System.out.print(e);
        }
        return result.toString();
    }

}
