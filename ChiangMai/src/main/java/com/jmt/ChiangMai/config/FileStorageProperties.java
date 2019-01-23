package com.jmt.ChiangMai.config;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@Setter // properties 읽으려면 setter 필요
@ConfigurationProperties(prefix = "file")
public class FileStorageProperties {
    private String baseDir;

    public String calcPath() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String path = baseDir + "/" + simpleDateFormat.format(new Date());
        new File(path).mkdirs();
        return path;
    }
}
