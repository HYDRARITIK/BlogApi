package com.hydra.demo;

import com.hydra.demo.Services.FileService;
import jakarta.annotation.Resource;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.io.File;

@SpringBootApplication
public class DemoApplication {


	@Resource
	FileService fileserv;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}


	public void run(String... arg) throws Exception {
//    storageService.deleteAll();
//		fileserv.init();
	}

}
