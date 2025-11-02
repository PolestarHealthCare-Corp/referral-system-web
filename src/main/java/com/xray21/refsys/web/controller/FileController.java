package com.xray21.refsys.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;


@Controller
public class FileController {
    @RequestMapping("/file")
    public String file() {
        return "file";
    }

    @PostMapping("/upload")
    public String upload(MultipartFile file) {
        String uploadDir = "C:/download/";//파일 저장 경로
        String fileName = file.getOriginalFilename(); //파일 원본 이름 가져오기
        File destination = new File(uploadDir + fileName); // 자바가 제공해주는 File 라이브러리를 통해
        try{
            if (!destination.getParentFile().exists()){
                destination.getParentFile().mkdirs();
            }
            file.transferTo(destination);
            System.out.println("파일업로드완료:"+ destination.getAbsolutePath());
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("FileController.upload " + file);
        return "home";

    }

}



