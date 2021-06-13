package com.tharindu.tailor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;



@SpringBootApplication
public class SpringBootTailorManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTailorManagementApplication.class, args);
	}
	
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        //config.exposeIdsFor(Customer.class);
    }

}
