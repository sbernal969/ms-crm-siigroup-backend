package com.crm.siigroup.crmApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class CrmAppApplication   {

	public static void main(String[] args) {
		SpringApplication.run(CrmAppApplication.class, args);
	}

}
