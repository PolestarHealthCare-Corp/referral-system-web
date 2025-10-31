package com.xray21.refsys.web.controller;

import com.xray21.refsys.web.dto.request.MemberJoinRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
    @RequestMapping("/file")
    public String file() {
        return "file";
    }

    @PostMapping("/upload")
    public String upload(MultipartFile file) {
        System.out.println("FileController.upload " + file);
        return "ok";

    }

}



