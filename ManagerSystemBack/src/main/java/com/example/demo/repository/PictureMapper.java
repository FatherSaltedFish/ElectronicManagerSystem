package com.example.demo.repository;

import com.example.demo.model.PictureModel;
import org.apache.poi.ss.usermodel.Picture;

public interface PictureMapper {

    Integer InsertPicture(PictureModel Picture);

    PictureModel GetPictureById(Integer PictureId);

    void UpdateProjectCostNumberByProjectId(Float Number,String ProjectId);

}
