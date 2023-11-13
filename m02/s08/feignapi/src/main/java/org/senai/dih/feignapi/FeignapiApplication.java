package org.senai.dih.feignapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FeignapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignapiApplication.class, args);
	}

}
