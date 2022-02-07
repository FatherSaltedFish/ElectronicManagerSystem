package com.example.demo.service.lmpl;


import com.example.demo.model.PeopleModel;
import com.example.demo.service.PeopleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("PeopleService")
public class PeopleServiceLmpl implements PeopleService {

    @Resource
    private com.example.demo.repository.PeopleMappler PeopleMappler;


    @Override
    public List<PeopleModel> GetAllPeople() {

        return PeopleMappler.GetAllPeople();
    }

    @Override
    public void AddPeople(String PeopleId, String PeopleName,String Email) {
        PeopleMappler.AddPeople(PeopleId,PeopleName,Email);
    }

    @Override
    public void DeletePeople(String PeopleId) {
        PeopleMappler.DeletePeople(PeopleId);
    }

    @Override
    public PeopleModel GetPeopleByPeopleId(String PeopleId) {
        return PeopleMappler.GetPeopleByPeopleId(PeopleId);
    }
}
