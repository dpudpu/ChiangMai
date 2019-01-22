package com.jmt.ChiangMai;

import com.jmt.ChiangMai.config.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class ChiangMaiApplication {
	public static void main(String[] args) {
		SpringApplication.run(ChiangMaiApplication.class, args);
	}

}

