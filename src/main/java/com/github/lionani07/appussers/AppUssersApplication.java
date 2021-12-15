package com.github.lionani07.appussers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableFeignClients
@SpringBootApplication
public class AppUssersApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppUssersApplication.class, args);
	}

}
