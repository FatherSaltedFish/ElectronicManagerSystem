package com.example.demo.Task;

import com.example.demo.model.ProjectModel;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import com.example.demo.controller.EmailController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class StaticTimeTask {

    @Resource
    private com.example.demo.service.ProjectService ProjectService;
    @Resource
    private com.example.demo.service.PeopleService PeopleService;
    @Resource
    private com.example.demo.service.ProjectPeopleService ProjectPeopleService;

    @Resource
    private com.example.demo.controller.EmailController EmailController;
//    /3.添加定时任务
    @Scheduled(cron = "0 0 1 * * ?")
    //或直接指定时间间隔，例如：5秒
    //@Scheduled(fixedRate=5000)
    private void configureTasks() {
        try {
            List<ProjectModel> ProjectModeList = ProjectService.FindOneDayProject();
            for(ProjectModel item:ProjectModeList){
                String PeopleId=ProjectPeopleService.FindMaster(item.getProjectId()).getPeopleId();
                EmailController.send(PeopleService.GetPeopleByPeopleId(PeopleId).getEmail());
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
