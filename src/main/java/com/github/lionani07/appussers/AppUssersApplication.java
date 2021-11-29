package com.github.lionani07.appussers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class AppUssersApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppUssersApplication.class, args);
	}

}
