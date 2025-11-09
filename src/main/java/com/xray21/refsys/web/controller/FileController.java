package com.xray21.refsys.web.controller;

import com.xray21.refsys.web.dto.Response;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.ui.Model;
import org.springframework.core.io.Resource;


//컨트롤러 시작
@Controller
public class FileController {
    private final String uploadDir = "C:/download/";
    //file 요청
    @RequestMapping("/file")
    public String file(Model model) {
        File folder = new File(uploadDir);
        List<String> fileNames = Arrays.stream(folder.listFiles())
                .filter(File :: isFile)
                .map(File :: getName)
                .collect(Collectors.toList());
                model.addAttribute("files", fileNames);
        return "file";
    }
    //파일 업로드 구현
    @PostMapping("/upload")
    public String upload(@RequestParam("file") List<MultipartFile> files) {
        int i;
        for(i=0; i<files.size(); i++){
            MultipartFile file = files.get(i);
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
    //업로드된 파일 저장
    @GetMapping("/download")
    @ResponseBody
    public ResponseEntity<Resource> downloadFile(@RequestParam String filename){
        File file = new File(uploadDir + filename);
        if(!file.exists()){
            return ResponseEntity.notFound().build();
        }
        Resource resource = new FileSystemResource(file);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
                .body(resource);
    }


}