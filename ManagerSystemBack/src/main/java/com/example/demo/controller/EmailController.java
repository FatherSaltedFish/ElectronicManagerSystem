package com.example.demo.controller;

import com.example.demo.model.PeopleModel;
import com.example.demo.model.ProjectModel;
import com.example.demo.model.ProjectPeopleModel;
import com.example.demo.service.ProjectPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@CrossOrigin
@RestController
public class EmailController {
    @Autowired
    JavaMailSender jsm;

    @Value("${spring.mail.username}")
    private String username;

    @Resource
    private com.example.demo.service.ProjectPeopleService ProjectPeopleService;

    @Resource
    private com.example.demo.service.PeopleService PeopleService;

    @RequestMapping("/SendEmail")
    public String SendEmail(@RequestParam(value="ProjectId")String ProjectId) throws JSONException {
        JSONObject result = new JSONObject();
        try {
            System.out.println(ProjectId);
            ProjectPeopleModel ppm = ProjectPeopleService.FindMaster(ProjectId);
            if (ppm == null) {
                result.put("boolean",false);
                result.put("wrong","未设置组长");
                return result.toString();
            }
            PeopleModel pm=PeopleService.GetPeopleByPeopleId(ppm.getPeopleId());
            System.out.println(pm);
            send(pm.getEmail());
            result.put("boolean",true);
            return result.toString();
        }catch(Exception e){
            result.put("boolean",false);
            result.put("wrong","未设置组长");
            System.out.println(e);
            return result.toString();
        }

    }


    public String send(String Email){
        //建立邮箱消息
        SimpleMailMessage message = new SimpleMailMessage();
        //发送者
        message.setFrom(username);
        //接收者
        message.setTo(Email);
        //发送标题
        message.setSubject("项目倒计时警告");
        //发送内容
        message.setText("项目马上就要截止了，请尽快完成项目并验收");
        jsm.send(message);
        return "1";
    }
}

