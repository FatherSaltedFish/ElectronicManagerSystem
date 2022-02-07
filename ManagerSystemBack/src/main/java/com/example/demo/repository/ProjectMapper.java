package com.example.demo.repository;

import com.example.demo.model.ProjectModel;

import java.util.Date;
import java.util.List;

public interface ProjectMapper {

    List<ProjectModel> GetAllProject();

    void FinishProject(String ProjectId, Date ProjectFinishTime);

    void CreateProject(String ProjectId,String ProjectName,Date ProjectTime,Float ProjectMoney);

    ProjectModel GetProjectByProjectId(String ProjectId);

    void UpdateProjectCostByProjectId(Float Number,String ProjectId);

    List<ProjectModel> FindOneDayProject();

    void DeleteProcess(String ProjectId);
}
