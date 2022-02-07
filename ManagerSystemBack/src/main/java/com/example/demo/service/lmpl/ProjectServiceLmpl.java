package com.example.demo.service.lmpl;


import com.example.demo.model.ProjectModel;
import com.example.demo.repository.ManagerMapper;
import com.example.demo.repository.ProjectMapper;
import com.example.demo.service.ProjectService;
import com.example.demo.service.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("ProjectService")
public class ProjectServiceLmpl implements ProjectService {
    @Resource
    private com.example.demo.repository.ProjectMapper ProjectMapper;

    @Override
    public List<ProjectModel> GetAllProject() {
        return ProjectMapper.GetAllProject();
    }

    @Override
    public void FinishProject(String ProjectId, Date ProjectFinishTime){
        ProjectMapper.FinishProject(ProjectId,ProjectFinishTime);
    }

    @Override
    public void CreateProject(String ProjectId, String ProjectName, Date ProjectTime, Float ProjectMoney){
        ProjectMapper.CreateProject(ProjectId,ProjectName,ProjectTime,ProjectMoney);
    }

    @Override
    public ProjectModel GetProjectByProjectId(String ProjectId){
        return ProjectMapper.GetProjectByProjectId(ProjectId);
    }

    @Override
    public void UpdateProjectCostByProjectId(Float Number, String ProjectId) {
        ProjectMapper.UpdateProjectCostByProjectId(Number,ProjectId);
    }

    @Override
    public List<ProjectModel> FindOneDayProject() {
        return ProjectMapper.FindOneDayProject();
    }

    @Override
    public void DeleteProcess(String ProjectId) {
        ProjectMapper.DeleteProcess(ProjectId);
    }


}
