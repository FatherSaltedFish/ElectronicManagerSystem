package com.example.demo.service;

import com.example.demo.model.ProjectModel;
import com.example.demo.repository.ProjectMapper;

import java.util.Date;
import java.util.List;

public interface ProjectService {

    public List<ProjectModel> GetAllProject();

    public void FinishProject(String ProjectId, Date ProjectFinishTime);


    void CreateProject(String ProjectId,String ProjectName,Date ProjectTime,Float ProjectMoney);

    ProjectModel GetProjectByProjectId(String ProjectId);

    void UpdateProjectCostByProjectId(Float Number, String ProjectId);

    List<ProjectModel> FindOneDayProject();

    void DeleteProcess(String ProjectId);
}
