package com.project.community_support.controller;

import com.project.community_support.dto.response.ApiResponse;
import com.project.community_support.dto.response.UserResponse;
import com.project.community_support.service.FileService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/files")
@CrossOrigin
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping(value = "/images",  consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ApiResponse<String> uploadImage(
        @RequestParam("file") MultipartFile file
    ){
         return ApiResponse.<String>builder()
                .result(fileService.uploadToCloudinary(file))
                .build();
    }
}
