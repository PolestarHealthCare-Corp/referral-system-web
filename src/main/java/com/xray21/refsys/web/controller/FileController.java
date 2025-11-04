package com.xray21.refsys.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.List;


@Controller
public class FileController {
    @RequestMapping("/file")
    public String file() {
        return "file";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") List<MultipartFile> files) {
        String uploadDir = "C:/download/";//파일 저장 경로
        int i;
        for(i=0; i<files.size(); i++){
            MultipartFile file = files.get(i);//이건 왜 갖고 와야하지??
            String fileName = file.getOriginalFilename();
            if(!files.isEmpty()){
                try{
                    File destination = new File(uploadDir + fileName);
                    destination.getParentFile().mkdirs();
                    file.transferTo(destination);
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        System.out.println("FileController.upload " + files);
        return "redirect:/file";

    }

}