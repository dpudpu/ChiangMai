package com.jmt.ChiangMai.util;

import com.jmt.ChiangMai.config.FileStorageProperties;
import com.jmt.ChiangMai.domain.ShopImage;
import com.jmt.ChiangMai.exception.FileUploadException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Component
public class FileUploadUtil {
    private final FileStorageProperties fileProperties;

    public ShopImage uploadFile(MultipartFile file) {
        String originalName = StringUtils.cleanPath(file.getOriginalFilename());
        String uuidStr = UUID.randomUUID().toString();
        String savedName = uuidStr + originalName;
        String savedPath = fileProperties.calcPath();

        File fileObj = new File(savedPath + savedName);

        try {
            FileCopyUtils.copy(file.getBytes(), fileObj);
        } catch (IOException ex) {
            throw new FileUploadException("Could not store file " + originalName + ". Please try again!", ex);
        }

        return ShopImage.builder()
                .originalName(originalName)
                .savedName(savedName)
                .type(file.getContentType())
                .size(file.getSize())
                .path(savedPath)
                .regDate(new Date())
                .build();
    }


}
