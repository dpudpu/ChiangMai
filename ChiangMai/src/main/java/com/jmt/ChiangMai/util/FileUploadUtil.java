package com.jmt.ChiangMai.util;

import com.jmt.ChiangMai.config.FileStorageProperties;
import com.jmt.ChiangMai.domain.ReviewImage;
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
    private String originalName;
    private String uuidStr;
    private String savedName;
    private String savedPath

    // TODO ShopImage에 종속적이지 않게 리턴 타입 변경해주기.
    public ShopImage uploadShopImage(MultipartFile file) {
        uploadFile(file);

        return ShopImage.builder()
                .originalName(originalName)
                .savedName(savedName)
                .type(file.getContentType())
                .size(file.getSize())
                .path(savedPath)
                .regDate(new Date())
                .build();
    }

    public ReviewImage uploadReviewImage(MultipartFile file) {
        uploadFile(file);

        return ReviewImage.builder()
                .originalName(originalName)
                .savedName(savedName)
                .type(file.getContentType())
                .size(file.getSize())
                .path(savedPath)
                .regDate(new Date())
                .build();
    }

    public void uploadFile(MultipartFile file) {
        originalName = StringUtils.cleanPath(file.getOriginalFilename());
        uuidStr = UUID.randomUUID().toString();
        savedName = uuidStr + originalName;
        savedPath = fileProperties.calcPath();

        File fileObj = new File(savedPath + savedName);

        try {
            FileCopyUtils.copy(file.getBytes(), fileObj);
        } catch (IOException ex) {
            throw new FileUploadException("Could not store file " + originalName + ". Please try again!", ex);
        }
    }


}
