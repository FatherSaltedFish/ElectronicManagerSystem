package com.example.demo.controller;

import com.example.demo.model.PictureModel;
import org.apache.poi.ss.usermodel.IconMultiStateFormatting;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


@CrossOrigin
@Controller
@EnableAutoConfiguration
@RequestMapping(value = {"/Picture"})
public class PictureController {

    @Resource
    private com.example.demo.service.PictureService PictureService;

    @ResponseBody
    @RequestMapping(value="/GetPicture",produces = "application/json;charset=UTF-8")
    public void getPic(final HttpServletResponse response, @RequestParam(value = "id")Integer id) throws IOException {
        PictureModel pic = PictureService.GetPictureById(id);
        byte[] data = pic.getPicture();
        response.setContentType("image/jpeg");
        response.setCharacterEncoding("UTF-8");
        OutputStream outputSream = response.getOutputStream();
        InputStream in = new ByteArrayInputStream(data);
        int len = 0;
        byte[] buf = new byte[1024];
        while ((len = in.read(buf, 0, 1024)) != -1) {
            outputSream.write(buf, 0, len);
        }
        outputSream.close();
    }


    //上传图片并返回 picid
    @ResponseBody
    @RequestMapping(value="/InsertPicture" ,produces = "application/json;charset=UTF-8",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String savePic(@RequestPart MultipartFile file, HttpServletResponse response) throws JSONException {
        JSONObject res = new JSONObject();
        if (file.isEmpty()) {
            res.put("boolean", false);
            res.put("wrong", "图片不能为空");
            return res.toString();
        }
        try {
            InputStream is = file.getInputStream();
            PictureModel u = new PictureModel();
            byte[] pic = new byte[(int)file.getSize()];
            is.read(pic);
            u.setPicture(pic);
            PictureService.InsertPicture(u);
            res.put("boolean", true);
            res.put("PictureId",String.valueOf(u.getPictureId()));
            return res.toString();
        } catch (IOException e) {
            e.printStackTrace();
            res.put("boolean",false);
            res.put("wrong",e);
        }
        return res.toString();
    }
}
