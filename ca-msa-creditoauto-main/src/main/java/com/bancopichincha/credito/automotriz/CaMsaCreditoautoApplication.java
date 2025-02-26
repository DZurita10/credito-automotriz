package com.bancopichincha.credito.automotriz;

import com.bancopichincha.credito.automotriz.utils.SaveInitialData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CaMsaCreditoautoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaMsaCreditoautoApplication.class, args);
	}
	@Bean(initMethod = "runInitialData")
	public SaveInitialData getFunnyBean() {
		return new SaveInitialData();
	}
}
