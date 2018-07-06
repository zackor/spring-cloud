package com.rrtx.ms.adm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.rrtx.ms.*")
public class AdmApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdmApplication.class, args);
	}
}
