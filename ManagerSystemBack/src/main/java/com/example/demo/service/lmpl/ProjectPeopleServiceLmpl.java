package com.example.demo.service.lmpl;

import com.example.demo.model.ProjectPeopleModel;
import com.example.demo.service.ProjectPeopleService;
import org.springframework.stereotype.Service;

import com.example.demo.service.ProjectPeopleService;

import javax.annotation.Resource;
import java.util.List;

@Service("ProjectPeopleService")

public class ProjectPeopleServiceLmpl implements ProjectPeopleService {

    @Resource
    private com.example.demo.repository.ProjectPeopleMapper ProjectPeopleMapper;
    @Override
    public List<ProjectPeopleModel> GetAllProjectPeopleByProjectId(String ProjectId) {
        return ProjectPeopleMapper.GetAllProjectPeopleByProjectId(ProjectId);
    }

    @Override
    public void DeleteProjectPeople(String ProjectId, String PeopleId){
            ProjectPeopleMapper.DeleteProjectPeople(ProjectId,PeopleId);
    }

    @Override
    public void AddProjectPeople(String ProjectId, String PeopleId, Boolean ManagerDecide, Float Per) {
        ProjectPeopleMapper.AddProjectPeople(ProjectId,PeopleId,ManagerDecide,Per);

    }

    @Override
    public void UpdateProjectPeople(String ProjectId, String PeopleId, Float Per) {
        ProjectPeopleMapper.UpdateProjectPeople(ProjectId,PeopleId,Per);
    }

    @Override
    public void SetMaster(String ProjectId, String PeopleId) {
        ProjectPeopleMapper.SetMaster(ProjectId,PeopleId);
    }

    @Override
    public void DeleteMaster(String ProjectId) {
        ProjectPeopleMapper.DeleteMaster(ProjectId);

    }

    @Override
    public ProjectPeopleModel GetProjectPeopleByProjectIdPeopleId(String ProjectId, String PeopleId) {
        return ProjectPeopleMapper.GetProjectPeopleByProjectIdPeopleId(ProjectId,PeopleId);
    }

    @Override
    public ProjectPeopleModel FindMaster(String ProjectId) {
        return ProjectPeopleMapper.FindMaster(ProjectId);
    }
}
