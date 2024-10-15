package com.project.community_support.service.storage;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service("CloudinaryStorage")
public class CloudinaryStorageService {

    private static final Logger log = LoggerFactory.getLogger(CloudinaryStorageService.class);

    private final Cloudinary cloudinary;

    public CloudinaryStorageService(
            Cloudinary cloudinary
    ) {
        this.cloudinary = cloudinary;
    }

    public String upload(String filePath, MultipartFile file) {
        String res = null;
        Map<String, String> params = ObjectUtils.asMap(
                "public_id", filePath,
                "resource_type", "auto");
        try {
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), params);
            res = uploadResult.get("url").toString();
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
        return res;
    }

}