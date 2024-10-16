package com.project.community_support.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileUtils {

    private static final Logger log = LoggerFactory.getLogger(FileUtils.class);

    private static final long GB = 1024 * 1024 * 1024;

    private static final long MB = 1024 * 1024;

    private static final long KB = 1024;

    public static final String IMAGE = "image";
    public static final String TXT = "text";
    public static final String MUSIC = "music";
    public static final String VIDEO = "video";
    public static final String OTHER = "other";

    public static String getExtensionName(String fileName){
        if(StringUtils.hasText(fileName)){
            int dot = fileName.lastIndexOf('.');
            if(dot >= 0 && dot < fileName.length() - 1){
                return fileName.substring(dot + 1);
            }
        }
        return fileName;
    }

    public static String getNoExtensionName(String fileName){
        if(StringUtils.hasText(fileName)){
            int dot = fileName.lastIndexOf('.');
            if(dot >= 0 && dot < fileName.length() - 1){
                return fileName.substring(0, dot);
            }
        }
        return fileName;
    }

    public static String getFileType(String type){
        final String documents = "txt doc pdf ppt pptx pps xlsx xls docx";
        final String music = "mp3 wav wma mpa ram ra aac aif m4a";
        final String video = "avi mpg mpe mpeg asf wmv mov qt rm mp4 flv m4v webm ogv ogg";
        final String image = "bmp dib pcp dif wmf gif jpg tif eps psd cdr iff tga pcd mpt png jpeg";

        if(documents.contains(type))
            return TXT;
        else if (music.contains(type))
            return MUSIC;
        else if (video.contains(type))
            return VIDEO;
        else if (image.contains(type))
            return IMAGE;
        else
            return OTHER;
    }

    public static String createFileNameWithTime(String fileName){
        String suffix = getExtensionName(fileName);
        String name = getNoExtensionName(fileName);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String now = LocalDateTime.now().format(formatter);
        return name + now;
    }
}