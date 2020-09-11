package com.tiremgmt.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.tiremgmt.tiremgmtcommon.TiremgmtCommonApplication;

@SpringBootApplication
@EntityScan(basePackageClasses = TiremgmtCommonApplication.class)
@EnableJpaRepositories(basePackageClasses = TiremgmtCommonApplication.class)
public class AuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationApplication.class, args);
	}

}
