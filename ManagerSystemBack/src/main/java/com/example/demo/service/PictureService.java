package com.example.demo.service;


import com.example.demo.model.PictureModel;
import org.apache.poi.ss.usermodel.Picture;

public interface PictureService {

    Integer InsertPicture(PictureModel Picture);

    PictureModel GetPictureById(Integer PictureId);
}
