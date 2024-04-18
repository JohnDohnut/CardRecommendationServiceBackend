package com.team7.controller.admin;


import com.team7.cloud.service.AwsS3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AwsS3Service awsS3Service;
    @GetMapping("/home")
    public void getHome(){

    }

    @PostMapping("/files/upload")
    public void postImage(@RequestParam MultipartFile file, @RequestParam String keyName) throws IOException {
        awsS3Service.uploadFile(keyName, file);
        return;
    }

    @GetMapping("/files/service/status")
    public String s3ServiceStatus(){
        return awsS3Service.serviceStatus();
    }

    @GetMapping("/files/download/{keyName}")
    public byte[] downloadImage(@PathVariable String keyName) throws IOException {
        return awsS3Service.getFile(keyName).getObjectContent().readAllBytes();
    }

    @GetMapping("/files/download/presigned/{keyName}")
    @ResponseBody
    public String downloadPresignedImageURL(@PathVariable String keyName) throws IOException{
        return awsS3Service.getFilePresignedURL(keyName);
    }

}
