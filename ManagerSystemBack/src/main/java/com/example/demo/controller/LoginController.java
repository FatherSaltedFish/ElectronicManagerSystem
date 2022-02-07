package com.example.demo.controller;

import com.example.demo.model.ManagerModel;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@CrossOrigin
@Controller
@EnableAutoConfiguration
@RequestMapping(value = {"/Login","/"})
public class LoginController {

    @Resource
    private com.example.demo.service.ManagerService ManagerService;

    @ResponseBody
    @RequestMapping(value="/CheckPassword",produces = "application/json;charset=UTF-8")
    public String CheckPassword(@RequestParam(value = "ManagerId", required = false) String ManagerId,
                                @RequestParam(value = "ManagerPassword", required = false) String ManagerPassword ) throws JSONException {
        ManagerModel ManagerModel=this.ManagerService.selectByManagerId(ManagerId);
        JSONObject result = new JSONObject();
        if(ManagerModel == null) {
            result.put("boolean", false);
            result.put("Wrong","用户不存在，请注册");
            return result.toString();
        }
        if(ManagerModel.getManagerPassword().equals(ManagerPassword))
        {
            result.put("boolean",true);
            result.put("ManagerInfo",ManagerModel);
        }else{
            result.put("Wrong","用户密码错误，请检查密码");
            result.put("boolean", false);
        }
        return result.toString();
    }

    @ResponseBody
    @RequestMapping(value = "/CreateNewManager",produces = "application/json;charset=UTF-8")
    public String CheckPassword(@RequestParam(value = "ManagerId", required = false) String ManagerId,
                                @RequestParam(value = "ManagerPassword", required = false) String ManagerPassword ,
                                @RequestParam(value = "Manager_Name", required = false) String ManagerName
                                ) throws JSONException {
        JSONObject result=new JSONObject();
        try {
            ManagerService.AddManager(new ManagerModel(ManagerId, ManagerPassword, ManagerName));
        }catch (Exception e){
            result.put("boolean",false);
            result.put("Wrong",e);
            return result.toString();
        }
        result.put("boolean",true);
        return result.toString();
    }


    @ResponseBody
    @RequestMapping(value = "/GetManagerName",produces = "application/json;charset=UTF-8")
    public String GetManagerName(@RequestParam(value = "ManagerId",required = false)String ManagerId) throws JSONException{
        JSONObject result = new JSONObject();
        ManagerModel Manager = new ManagerModel();
        if(ManagerId == null) {
            result.put("boolean", false);
            result.put("Wrong","未传输用户信息，请重试");
            return result.toString();
        }
        try{
            Manager=ManagerService.GetManageName(ManagerId);
        }catch (Exception e){
            result.put("boolean",false);
            result.put("Wrong",e);
            return result.toString();
        }
        result.put("boolean",true);
        result.put("ManagerName",Manager.getManager_Name());
        return result.toString();
    }


}
