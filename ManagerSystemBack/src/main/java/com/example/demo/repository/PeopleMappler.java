package com.example.demo.repository;

import com.example.demo.model.PeopleModel;

import java.util.List;

public interface PeopleMappler {

    List<PeopleModel> GetAllPeople();

    void AddPeople(String PeopleId,String PeopleName,String Email);

    void DeletePeople(String PeopleId);

    PeopleModel GetPeopleByPeopleId(String PeopleId);
}
