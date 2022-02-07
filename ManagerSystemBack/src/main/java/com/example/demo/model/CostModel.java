package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class CostModel {
    String CostId,ProjectId;
    Float CostNumber;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    Date CostTime;
    String CostDetail;
    Integer PictureId;

    public CostModel(String costId, String projectId, Float costNumber, Date costTime, String costDetail, Integer pictureId) {
        CostId = costId;
        ProjectId = projectId;
        CostNumber = costNumber;
        CostTime = costTime;
        CostDetail = costDetail;
        PictureId = pictureId;
    }

    @Override
    public String toString() {
        return "CostModel{" +
                "CostId='" + CostId + '\'' +
                ", ProjectId='" + ProjectId + '\'' +
                ", CostNumber=" + CostNumber +
                ", CostTime=" + CostTime +
                ", CostDetail='" + CostDetail + '\'' +
                ", PictureId=" + PictureId +
                '}';
    }

    public CostModel() {
    }

    public String getCostDetail() {
        return CostDetail;
    }

    public void setCostDetail(String costDetail) {
        CostDetail = costDetail;
    }

    public Integer getPictureId() {
        return PictureId;
    }

    public void setPictureId(Integer pictureId) {
        PictureId = pictureId;
    }

    public String getCostId() {
        return CostId;
    }

    public void setCostId(String costId) {
        CostId = costId;
    }

    public String getProjectId() {
        return ProjectId;
    }

    public void setProjectId(String projectId) {
        ProjectId = projectId;
    }

    public Float getCostNumber() {
        return CostNumber;
    }

    public void setCostNumber(Float costNumber) {
        CostNumber = costNumber;
    }

    public Date getCostTime() {
        return CostTime;
    }

    public void setCostTime(Date costTime) {
        CostTime = costTime;
    }
}
