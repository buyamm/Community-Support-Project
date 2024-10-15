package com.project.community_support.service;

import com.project.community_support.service.storage.CloudinaryStorageService;
import com.project.community_support.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


@Service
@Transactional
public class FileService {

    private final static Logger log = LoggerFactory.getLogger(FileService.class);

    private final CloudinaryStorageService cloudinaryStorageService;

    public FileService(CloudinaryStorageService cloudinaryStorageService) {
        this.cloudinaryStorageService = cloudinaryStorageService;
    }

    public String uploadToCloudinary(MultipartFile file) {
        String suffix = FileUtils.getExtensionName(file.getOriginalFilename());
        String type = FileUtils.getFileType(suffix);
        String name = FileUtils.createFileNameWithTime(file.getOriginalFilename());
        String fileName = "uploads/" + type + "/" + name;

        return cloudinaryStorageService.upload(fileName, file);
    }


}
