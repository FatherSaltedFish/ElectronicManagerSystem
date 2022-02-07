package com.example.demo.service;

import com.example.demo.model.PeopleModel;

import java.util.List;

public interface PeopleService {

    List<PeopleModel> GetAllPeople();

    void AddPeople(String PeopleId,String PeopleName,String Email);

    void DeletePeople(String PeopleId);

    PeopleModel GetPeopleByPeopleId(String PeopleId);


}
