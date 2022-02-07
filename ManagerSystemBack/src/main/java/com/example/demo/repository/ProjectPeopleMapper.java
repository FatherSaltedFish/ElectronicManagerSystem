package com.example.demo.repository;

import com.example.demo.model.ProjectPeopleModel;

import java.util.List;

public interface ProjectPeopleMapper {

    List<ProjectPeopleModel> GetAllProjectPeopleByProjectId(String ProjectId);

    void DeleteProjectPeople(String ProjectId,String PeopleId);

    void AddProjectPeople(String ProjectId,String PeopleId,Boolean ManagerDecide,Float Per);

    void UpdateProjectPeople(String ProjectId,String PeopleId,Float Per);

    void SetMaster(String ProjectId,String PeopleId);

    void DeleteMaster(String ProjectId);

    ProjectPeopleModel GetProjectPeopleByProjectIdPeopleId(String ProjectId,String PeopleId);

    ProjectPeopleModel FindMaster(String ProjectId);


}
