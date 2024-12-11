package com.rd927.second;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.Import;

// import com.rd927.second.config.AppConfig;

@SpringBootApplication(scanBasePackages = "com.rd927.second")
public class SecondApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondApplication.class, args);
	}

}
