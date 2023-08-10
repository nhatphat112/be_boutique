package com.teamwork.boutique.controller;

import com.teamwork.boutique.exception.CustomFileNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
@RequestMapping("")
@CrossOrigin(value = "*")
public class UploadFileController {
    //Path: chứa toàn bộ hàm hỗ trợ sẵn liên quan tới đường dẫn
    @Value("${path.root}")
    private String spath;

    @PostMapping("/uploadfile")
    public ResponseEntity<?> uploadFile(
            @RequestParam MultipartFile file
    ) {
        boolean isSuccess = false;
        //Định nghĩa đường dẫn
        Path rootPath = Paths.get(spath);//nio library
        try{
            if(!Files.exists(rootPath)){// nếu đường dẫn không tồn tại, tạo folder ứng với
                Files.createDirectory(rootPath);
            }
            String fileName = file.getOriginalFilename();
            Files.copy(file.getInputStream(),rootPath.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
            isSuccess = true;
        }
        catch(Exception e){
            System.out.println("Loi" + e.getLocalizedMessage());
        }
        return new ResponseEntity<>(isSuccess, HttpStatus.OK);
    }
    @GetMapping("/downloadfile/{filename}")
    public ResponseEntity<?> downloadFile(
            @PathVariable String filename
    ) {
        System.out.println("vao ham download file");
        try {
            Path rootPath = Paths.get(spath);
            Path file = rootPath.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists()||resource.isReadable()){
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION,
                                "attachment; filename=\"" + resource.getFilename() + "\"")
                        .body(file);
            }
            else{
                throw new CustomFileNotFoundException(200,"File notfound");
            }
        }
        catch(MalformedURLException e){
            throw new CustomFileNotFoundException(200,"File notfound");
        }
    }
}
