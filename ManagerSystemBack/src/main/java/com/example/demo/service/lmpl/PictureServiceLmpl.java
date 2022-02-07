package com.example.demo.service.lmpl;


import com.example.demo.model.PictureModel;
import com.example.demo.service.PictureService;
import org.apache.poi.ss.usermodel.Picture;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("PictureService")
public class PictureServiceLmpl implements PictureService {

    @Resource
    private com.example.demo.repository.PictureMapper PictureMapper;

    @Override
    public Integer InsertPicture(PictureModel Picture) {
        return PictureMapper.InsertPicture(Picture);
    }

    @Override
    public PictureModel GetPictureById(Integer PictureId) {
        return PictureMapper.GetPictureById(PictureId);
    }
}
