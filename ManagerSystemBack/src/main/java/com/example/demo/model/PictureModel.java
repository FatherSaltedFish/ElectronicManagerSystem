package com.example.demo.model;

import java.util.Arrays;

public class PictureModel {
    Integer PictureId;
    byte[] Picture;

    public PictureModel() {
    }

    public PictureModel(Integer pictureId, byte[] picture) {
        PictureId = pictureId;
        Picture = picture;
    }

    public Integer getPictureId() {
        return PictureId;
    }

    public void setPictureId(Integer pictureId) {
        PictureId = pictureId;
    }

    public byte[] getPicture() {
        return Picture;
    }

    public void setPicture(byte[] picture) {
        Picture = picture;
    }
}
