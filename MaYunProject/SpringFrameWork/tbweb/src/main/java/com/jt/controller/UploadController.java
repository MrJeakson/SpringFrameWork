package com.jt.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/upload/")
public class UploadController {


    @RequestMapping("uploadUI")
    public String uploadUI() {

        return "upload";
    }

    @RequestMapping("doUpload")
    public ModelAndView doUpload(MultipartFile upfile) throws IOException {

        //获取文件名以及文件大小，检测是否获得文件相关数据
        String fileName = upfile.getOriginalFilename();
        long size = upfile.getSize();
        System.out.println(fileName + "/" + size);
        //构建文件目标对象，这个对象对应的文件路径必须是存在的或者通过file对象自己创建
        File dest = new File("D:/upload/" + fileName);

        //transferto 实现文件上传
        upfile.transferTo(dest);

        ModelAndView mv = new ModelAndView("upload");

        mv.addObject("msg", "upload ok");

        return mv;


    }

}
